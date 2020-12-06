package com.cskaoyan.gateway.controller.user;


import com.mall.commons.result.ResponseData;
import com.mall.commons.result.ResponseUtil;
import com.mall.user.IUserRegisterService;
import com.mall.user.annotation.Anoymous;
import com.mall.user.constants.SysRetCodeConstants;
import com.mall.user.dto.UserRegisterRequest;
import com.mall.user.dto.UserRegisterResponse;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * author: OldChicken
 * date: 12-05
 */

@RestController
@RequestMapping("/user")
public class RegisterController {
    @Reference(timeout = 3000, check = false)
    IUserRegisterService iUserRegisterService;

    @Anoymous
    @PostMapping("/register")
    public ResponseData userRegister(@RequestBody Map<String,String> map, HttpServletRequest request){
        String username = map.get("username");
        String password = map.get("password");
        String email = map.get("email");
        String sex = map.get("sex");
        String name = map.get("name");
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setUserName(username);
        userRegisterRequest.setUserPwd(password);
        userRegisterRequest.setEmail(email);
        userRegisterRequest.setSex(sex);
        userRegisterRequest.setName(name);

        UserRegisterResponse userRegisterResponse = iUserRegisterService.userRegister(userRegisterRequest);
        if(userRegisterResponse.getCode().equals(SysRetCodeConstants.SUCCESS.getCode())) {
            return new ResponseUtil().setData(null);
        }
        return new ResponseUtil().setErrorMsg(userRegisterResponse.getMsg());
    }

}
