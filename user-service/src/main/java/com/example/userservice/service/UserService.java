package com.example.userservice.service;

import com.example.userservice.model.request.UserInfoRequest;

public interface UserService {
    void register(UserInfoRequest userInfoRequest);
    void sendVerifyCode(Long userId);
    boolean verifyByCode(Long userId, String code);
}
