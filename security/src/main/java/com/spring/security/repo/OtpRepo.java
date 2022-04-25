package com.spring.security.repo;

import com.spring.security.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepo extends JpaRepository<Otp,String> {
    Optional<Otp> findOtpByUsername(String username);
}
