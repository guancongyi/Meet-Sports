package com.cskaoyan.gateway.controller.user;


import com.mall.commons.result.ResponseData;
import com.mall.commons.result.ResponseUtil;
import com.mall.commons.tool.utils.CookieUtil;
import com.mall.user.IUserLoginService;
import com.mall.user.annotation.Anoymous;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.dto.UserLoginRequest;
import com.mall.user.dto.UserLoginResponse;
import com.mall.user.intercepter.TokenIntercepter;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Reference(timeout = 3000,check = false)
    IUserLoginService iUserLoginService;

    @Anoymous
    @PostMapping("/login")
    public ResponseData userLogin(@RequestBody Map<String,String> map,
                                  HttpServletRequest request){
        UserLoginRequest loginRequest = new UserLoginRequest();
        loginRequest.setUserName(map.get("username"));
        loginRequest.setUserPwd(map.get("password"));
        UserLoginResponse loginResponse = iUserLoginService.userLogin(loginRequest);
        if(loginResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil().setData(loginResponse);
        }
        return new ResponseUtil().setErrorMsg(loginResponse.getMsg());
    }
}
