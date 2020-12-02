package com.mall.user.dto;

import com.mall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * @author: jia.xue
 * @create: 2020-09-15 17:21
 * @Description
 **/
@Data
public class GetAllUserResponse extends AbstractResponse {

    List<UserDTO> userDTOS;
}