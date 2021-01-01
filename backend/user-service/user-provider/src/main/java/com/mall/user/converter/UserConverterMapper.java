package com.mall.user.converter;

import com.mall.user.dal.entitys.Member;
import com.mall.user.dal.entitys.User;
import com.mall.user.dto.UserLoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 *  oldchicken
 * create-date: 2019/7/22-18:05
 */
@Mapper(componentModel = "spring")
public interface UserConverterMapper {

    @Mappings({})
    UserLoginResponse loginConverter(User user);

}
