package com.mall.user;


import com.mall.user.dto.UserLoginRequest;
import com.mall.user.dto.UserLoginResponse;
import com.mall.user.dto.UserRegisterRequest;

/**
 * oldChicken
 * create-date: 2020/12/04
 * 用户服务
 */
public interface IUserLoginService {

    /**
     * 用户登录
     * @param request
     * @return
     */
    UserLoginResponse userLogin(UserLoginRequest request);
}
