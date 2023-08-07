package com.example.userservice.repository;

import com.example.userservice.model.entity.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, Long> {
    Optional<VerifyCode> findVerifyCodeByUserIdAndCode(Long userId, String code);
}
