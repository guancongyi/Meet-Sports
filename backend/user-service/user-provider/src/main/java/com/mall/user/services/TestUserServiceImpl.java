package com.mall.user.services;

import com.mall.user.TestUserService;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.converter.MemberConverter;
import com.mall.user.dal.entitys.Member;
import com.mall.user.dal.persistence.MemberMapper;
import com.mall.user.dto.GetAllUserRequest;
import com.mall.user.dto.GetAllUserResponse;
import com.mall.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: jia.xue
 * @create: 2020-09-15 17:25
 * @Description
 **/
@Service
@Slf4j
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberConverter memberConverter;

    @Override
    public GetAllUserResponse getAllUser(GetAllUserRequest request) {

        request.requestCheck();

        GetAllUserResponse response = new GetAllUserResponse();

        log.info("刘师傅:{}, 薛师傅:{}", "zhenshuai", "zhenchou");

        List<Member> members = memberMapper.selectAll();

        List<UserDTO> userDTOS = memberConverter.convert2DTOs(members);

        response.setUserDTOS(userDTOS);

        response.setCode(SysRetCodeConstants.SUCCESS.getCode());
        response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        return response;
    }
}