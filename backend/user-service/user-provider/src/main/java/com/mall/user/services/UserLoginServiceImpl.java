package com.mall.user.services;

import com.mall.user.IUserLoginService;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.converter.UserConverterMapper;
import com.mall.user.dal.entitys.User;
import com.mall.user.dal.persistence.UserMapper;
import com.mall.user.dto.UserLoginRequest;
import com.mall.user.dto.UserLoginResponse;
import com.mall.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
@Component
@Service
public class UserLoginServiceImpl implements IUserLoginService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserConverterMapper userConverterMapper;

    @Override
    public UserLoginResponse userLogin(UserLoginRequest request) {
        log.info("Begin UserLoginServiceImpl.login: request:"+request);
        UserLoginResponse response = new UserLoginResponse();
        try{
            request.requestCheck();
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo("username", request.getUserName());
            List<User> user = userMapper.selectByExample(example);
            if(user == null || user.size() == 0){
                response.setCode(SysRetCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(SysRetCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }
            if(!DigestUtils.md5DigestAsHex(request.getUserPwd().getBytes()).equals(user.get(0).getPassword())){
                response.setCode(SysRetCodeConstants.USERORPASSWORD_ERRROR.getCode());
                response.setMsg(SysRetCodeConstants.USERORPASSWORD_ERRROR.getMessage());
                return response;
            }
            response = userConverterMapper.loginConverter(user.get(0));
            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        }catch (Exception e){
            e.printStackTrace();
            log.error("UserLoginServiceImpl.login Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }
        return response;
    }
}
