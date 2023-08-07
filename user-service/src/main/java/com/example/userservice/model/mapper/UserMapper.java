package com.example.userservice.model.mapper;

import com.example.userservice.model.entity.User;
import com.example.userservice.model.request.UserInfoRequest;
import com.example.userservice.model.response.UserInfoResponse;

public class UserMapper {
    public static User toEntity(UserInfoRequest userInfoRequest) {
        return User.builder()
                .name(userInfoRequest.getName())
                .email(userInfoRequest.getEmail())
                .username(userInfoRequest.getUsername())
                .build();
    }

    public static UserInfoResponse toDto(User user) {
        return UserInfoResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }
}
