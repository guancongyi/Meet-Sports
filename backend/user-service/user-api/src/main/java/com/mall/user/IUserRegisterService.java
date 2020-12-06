package com.mall.user;

import com.mall.user.dto.*;

/**
 * oldChicken
 * create-date: 2020/12/04
 * 用户服务
 */
public interface IUserRegisterService {

    /**
     * 用户注册
     * @param request
     * @return
     */
    UserRegisterResponse userRegister(UserRegisterRequest request);


}
