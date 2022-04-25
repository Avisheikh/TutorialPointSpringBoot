package com.spring.security.service;

import com.spring.security.entity.Otp;
import com.spring.security.entity.User;
import com.spring.security.repo.OtpRepo;
import com.spring.security.repo.UserRepo;
import com.spring.security.util.GenerateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OtpRepo otpRepo;


    public void addUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public void auth(User user)
    {
        Optional<User> o =userRepo.findUserByUsername(user.getUsername());

        if(o.isPresent()) {

            User u = o.get();
            if(passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                renewOtp(u);
            }

            else {
                throw new BadCredentialsException("Bad Credentials.");
            }
        }
        else {

            throw new BadCredentialsException("Bad Credentials.");
        }
    }

    private void renewOtp(User u){
        String code = GenerateCodeUtil.generateCode();

        Optional<Otp> userOtp = otpRepo.findOtpByUsername(u.getUsername());

        if(userOtp.isPresent()){
            Otp otp = userOtp.get();
            otp.setCode(code);
        }
        else {
            Otp otp = new Otp();

            otp.setUsername(u.getUsername());
            otp.setCode(code);
            otpRepo.save(otp);
        }

    }

    public boolean check(Otp otpToValidate){

        Optional<Otp> userOtp = otpRepo.findOtpByUsername(otpToValidate.getUsername());

        if(userOtp.isPresent()) {
            Otp otp = userOtp.get();
            if(otpToValidate.getCode().equals(otp.getCode()))
            {
                return true;
            }
        }
        return false;
    }


}
