package com.shivam.projects.lovable_clone.Mapper;


import com.shivam.projects.lovable_clone.dto.auth.SignupRequest;
import com.shivam.projects.lovable_clone.dto.auth.UserProfileResponse;
import com.shivam.projects.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);
    UserProfileResponse userProfileResponse(User user);
}
