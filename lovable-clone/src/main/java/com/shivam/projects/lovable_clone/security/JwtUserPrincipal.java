package com.shivam.projects.lovable_clone.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public record JwtUserPrincipal(Long userId, String userName, List<GrantedAuthority> authorities) {
}
