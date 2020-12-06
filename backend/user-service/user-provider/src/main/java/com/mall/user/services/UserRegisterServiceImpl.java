package com.mall.user.services;

import com.mall.commons.tool.exception.ValidateException;
import com.mall.user.IUserRegisterService;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.dal.entitys.Member;
import com.mall.user.dal.entitys.User;
import com.mall.user.dal.persistence.MemberMapper;
import com.mall.user.dal.persistence.UserMapper;
import com.mall.user.dto.UserRegisterRequest;
import com.mall.user.dto.UserRegisterResponse;
import com.mall.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Slf4j
@Component
@Service
public class UserRegisterServiceImpl implements IUserRegisterService {
    @Autowired
    UserMapper userMapper;


    @Override
    public UserRegisterResponse userRegister(UserRegisterRequest request) {
        log.info("Begin UserLoginServiceImpl.register: request:" + request);
        UserRegisterResponse response = new UserRegisterResponse();
        try{
            isUserAlreadyExisted(request);
            User user = new User();
            user.setUsername(request.getUserName());
            user.setPassword(DigestUtils.md5DigestAsHex(request.getUserPwd().getBytes()));
            user.setName(request.getName());
            user.setCreated_at(new Date());
            user.setUpdated_at(new Date());
            user.setEmail(request.getEmail());
            user.setSex(request.getSex());
            if(userMapper.insert(user) != 1){ //if insert success, 1 means success
                response.setCode(SysRetCodeConstants.USER_REGISTER_FAILED.getCode());
                response.setMsg(SysRetCodeConstants.USER_REGISTER_FAILED.getMessage());
                return response;
            }
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("UserLoginServiceImpl.register Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    private void isUserAlreadyExisted(UserRegisterRequest request){
        request.requestCheck();
        Example example = new Example(Member.class);
        example.createCriteria().andEqualTo("username", request.getUserName());

        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            throw new ValidateException(SysRetCodeConstants.USERNAME_ALREADY_EXISTS.getCode(), SysRetCodeConstants.USERNAME_ALREADY_EXISTS.getMessage());
        }
    }
}
