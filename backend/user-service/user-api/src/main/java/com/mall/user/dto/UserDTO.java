package com.mall.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: jia.xue
 * @create: 2020-09-15 17:23
 * @Description
 **/
@Data
public class UserDTO implements Serializable {

    String username;

    String email;

    Date created;
}