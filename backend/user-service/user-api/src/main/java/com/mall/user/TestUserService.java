package com.mall.user;

import com.mall.user.dto.GetAllUserRequest;
import com.mall.user.dto.GetAllUserResponse;

/**
 * @author: jia.xue
 * @create: 2020-09-15 17:20
 * @Description
 **/
public interface TestUserService {

    GetAllUserResponse getAllUser(GetAllUserRequest request);
}