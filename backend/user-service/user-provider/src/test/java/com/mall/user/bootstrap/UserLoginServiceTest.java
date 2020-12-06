package com.mall.user.bootstrap;

import com.alibaba.fastjson.JSON;
import com.mall.user.IUserLoginService;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.dto.UserLoginRequest;
import com.mall.user.dto.UserLoginResponse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class UserLoginServiceTest extends UserProviderApplicationTests {

    @Autowired
    private IUserLoginService userLoginService;

    @Test
    public void test01(){ //invalid username test,fail test
        UserLoginRequest request = new UserLoginRequest();
        request.setUserName("somebody");
        request.setUserPwd("somebody");
        UserLoginResponse response = userLoginService.userLogin(request);
        System.out.println(JSON.toJSONString(response));
        assertEquals(SysRetCodeConstants.USERORPASSWORD_ERRROR.getCode(), response.getCode());
        assertEquals(SysRetCodeConstants.USERORPASSWORD_ERRROR.getMessage(), response.getMsg());
    }
    @Test
    public void test02(){ //valid user test,success test
        UserLoginRequest request = new UserLoginRequest();
        request.setUserName("jiezoc");
        request.setUserPwd("jiezoc");
        UserLoginResponse response = userLoginService.userLogin(request);
        System.out.println(JSON.toJSONString(response));
        assertEquals(SysRetCodeConstants.SUCCESS.getCode(), response.getCode());
        assertEquals(SysRetCodeConstants.SUCCESS.getMessage(), response.getMsg());
    }


}
