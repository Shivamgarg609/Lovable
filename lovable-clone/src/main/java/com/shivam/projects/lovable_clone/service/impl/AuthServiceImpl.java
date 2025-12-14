package com.shivam.projects.lovable_clone.service.impl;

import com.shivam.projects.lovable_clone.Mapper.UserMapper;
import com.shivam.projects.lovable_clone.dto.auth.AuthResponse;
import com.shivam.projects.lovable_clone.dto.auth.LoginRequest;
import com.shivam.projects.lovable_clone.dto.auth.SignupRequest;
import com.shivam.projects.lovable_clone.entity.User;
import com.shivam.projects.lovable_clone.error.BadRequestException;
import com.shivam.projects.lovable_clone.repository.UserRepository;
import com.shivam.projects.lovable_clone.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse signup(SignupRequest signupRequest) {

        userRepository.findByUsername(signupRequest.username())
                .ifPresent(user -> {throw new BadRequestException("User already exists with userId" +signupRequest.username());});

        User user = userMapper.toEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(signupRequest.password()));
        user = userRepository.save(user);
        return new AuthResponse("dummy",userMapper.userProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
