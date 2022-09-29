package com.emrealkan.restapiforkotlin.mapper;

import com.emrealkan.restapiforkotlin.dto.UserResponse;
import com.emrealkan.restapiforkotlin.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "userName",source = "userName")
    @Mapping(target = "role",source = "role")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "profileImgUrl",source = "profileImgUrl")
    public UserResponse mapToDto(User user);


}
