package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.AuthResponse;
import com.shivam.projects.lovable_clone.dto.auth.LoginRequest;
import com.shivam.projects.lovable_clone.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest);

    AuthResponse login(LoginRequest request);
}
