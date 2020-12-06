package com.mall.user.dto;

import com.mall.commons.result.AbstractResponse;
import lombok.Data;

/**
 *  ciggar
 * create-date: 2019/7/22-13:10
 */
@Data
public class UserLoginResponse extends AbstractResponse {

    private Long id;
    private String username;
    private String name;
    private String email;
    private String sex;
    private String icon;
}
