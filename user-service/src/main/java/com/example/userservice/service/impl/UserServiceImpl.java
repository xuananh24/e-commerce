package com.example.userservice.service.impl;

import com.example.userservice.common.constant.RoleConstant;
import com.example.userservice.common.constant.StatusConstant;
import com.example.userservice.model.entity.User;
import com.example.userservice.model.entity.VerifyCode;
import com.example.userservice.model.mapper.UserMapper;
import com.example.userservice.model.request.UserInfoRequest;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.repository.VerifyCodeRepository;
import com.example.userservice.service.UserService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final VerifyCodeRepository verifyCodeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JavaMailSender javaMailSender;

    public UserServiceImpl(UserRepository userRepository, VerifyCodeRepository verifyCodeRepository, PasswordEncoder passwordEncoder, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.verifyCodeRepository = verifyCodeRepository;
        this.passwordEncoder = passwordEncoder;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void register(UserInfoRequest userInfoRequest) {
        if (!userRepository.findUserByUsername(userInfoRequest.getUsername()).isPresent()) {
            User user = UserMapper.toEntity(userInfoRequest);
            user.setRoles(RoleConstant.ROLE_USER);
            user.setStatus(StatusConstant.STATUS_UNVERIFIED);
            user.setPassword(passwordEncoder.encode(userInfoRequest.getPassword()));
            userRepository.save(user);
        }
    }

    @Override
    public void sendVerifyCode(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            VerifyCode verifyCode = VerifyCode.builder()
                    .userId(userId)
                    .code(getRandomString())
                    .build();
            verifyCodeRepository.save(verifyCode);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("xuananh24121999@gmail.com");
            simpleMailMessage.setTo(user.getEmail());
            simpleMailMessage.setSubject("E-commerce verify account");
            simpleMailMessage.setText("This is verify code: " + verifyCode.getCode());
            javaMailSender.send(simpleMailMessage);
        }

    }

    @Override
    public boolean verifyByCode(Long userId, String code) {
        Optional<VerifyCode> verifyCodeOptional = verifyCodeRepository.findVerifyCodeByUserIdAndCode(userId, code);
        if (verifyCodeOptional.isPresent()) {
            User user = userRepository.findById(userId).orElse(null);
            if (user != null) {
                user.setStatus(StatusConstant.STATUS_VERIFIED);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }


    public String getRandomString() {
        String uuid = UUID.randomUUID().toString();
        String randomString = uuid.replaceAll("-", "");

        int maxLength = 10;
        if (randomString.length() > maxLength) {
            randomString = randomString.substring(0, maxLength);
        }

        return randomString;
    }
}
