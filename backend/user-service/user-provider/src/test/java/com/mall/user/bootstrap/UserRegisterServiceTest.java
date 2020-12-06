package com.mall.user.bootstrap;

import com.alibaba.fastjson.JSON;
import com.mall.user.IUserRegisterService;
import com.mall.user.dto.UserRegisterRequest;
import com.mall.user.dto.UserRegisterResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class UserRegisterServiceTest extends UserProviderApplicationTests {
    @Autowired
    private IUserRegisterService registerService;


    @Test
    public void test01(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUserName("jiezoc");
        request.setUserPwd("jiezoc");
        request.setName("oldChicken");
        request.setEmail("jiezoc@outlook.com");
        UserRegisterResponse response = registerService.userRegister(request);
        System.out.println(JSON.toJSONString(response));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
