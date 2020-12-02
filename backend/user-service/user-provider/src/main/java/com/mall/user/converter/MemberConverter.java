package com.mall.user.converter;

import com.mall.user.dal.entitys.Member;
import com.mall.user.dto.QueryMemberResponse;
import com.mall.user.dto.UpdateMemberRequest;
import com.mall.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 *  ciggar
 * create-date: 2019/7/31-上午12:05
 */
@Mapper(componentModel = "spring")
public interface MemberConverter {

    @Mappings({})
    QueryMemberResponse member2Res(Member member);

    @Mappings({})
    Member updateReq2Member(UpdateMemberRequest request);

    @Mappings({
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "created",target = "created"),
    })
    UserDTO convert2DTO(Member member);

    List<UserDTO> convert2DTOs(List<Member> member);
}
