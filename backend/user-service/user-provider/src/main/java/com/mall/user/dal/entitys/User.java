package com.mall.user.dal.entitys;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
@Data
@ToString
public class User {
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码 md5加密存储
     */
    private String password;

    private String name;


    /**
     * 注册邮箱
     */
    private String email;

    private String sex;

    /**
     * 头像
     */
    private String icon;

    private Date created_at;

    private Date updated_at;

    private float longitude;

    private float latitude;


}