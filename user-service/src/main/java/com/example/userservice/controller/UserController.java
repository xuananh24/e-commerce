package com.example.userservice.controller;

import com.example.userservice.common.constant.PathConstant;
import com.example.userservice.model.request.UserInfoRequest;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = PathConstant.API_USER_CREATE_URL)
    public void register(@RequestBody UserInfoRequest userInfoRequest) {
        userService.register(userInfoRequest);
    }

    @PostMapping(value = PathConstant.API_USER_SEND_VERIFY_CODE_URL)
    public void sendVerifyCode(@PathVariable Long userId) {
        userService.sendVerifyCode(userId);
    }

    @PostMapping(value = PathConstant.API_USER_VERIFY_CODE_URL)
    public boolean verifyByCode(@PathVariable Long userId,@RequestParam(value = "code") String code) {
        return userService.verifyByCode(userId, code);
    }
}
