package com.shivam.projects.lovable_clone.dto.auth.member;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;

public record InviteMemberRequest(String email, ProjectRole projectRole) {
}
