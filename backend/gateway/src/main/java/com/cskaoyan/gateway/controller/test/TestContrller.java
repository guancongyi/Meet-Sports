package com.cskaoyan.gateway.controller.test;

import com.mall.commons.result.ResponseData;
import com.mall.commons.result.ResponseUtil;
import com.mall.user.TestUserService;
import com.mall.user.annotation.Anoymous;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.dto.GetAllUserRequest;
import com.mall.user.dto.GetAllUserResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jia.xue
 * @create: 2020-09-15 17:17
 * @Description
 **/

@RestController
@Anoymous
public class TestContrller {

    @Reference
    TestUserService testUserService;

    @GetMapping("allUser")
    public ResponseData getAllUser(){

        GetAllUserRequest getAllUserRequest = new GetAllUserRequest();

        GetAllUserResponse response = testUserService.getAllUser(getAllUserRequest);

        if(response.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())){

            ResponseData responseData = new ResponseUtil().setData(response.getUserDTOS());

            return responseData;

        }else {

            return null;
        }


    }
}