package com.shivam.projects.lovable_clone.dto.auth.member;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;

import java.time.Instant;

public record MemberResponse(Long id, String name, String email, String avatarUrl, ProjectRole projectRole, Instant invitedAt) {
}
