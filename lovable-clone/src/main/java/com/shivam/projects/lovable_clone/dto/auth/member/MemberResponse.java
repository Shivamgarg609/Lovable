package com.shivam.projects.lovable_clone.dto.auth.member;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;

import java.time.Instant;

public record MemberResponse(Long userId, String name, String email, ProjectRole projectRole, Instant invitedAt) {
}
