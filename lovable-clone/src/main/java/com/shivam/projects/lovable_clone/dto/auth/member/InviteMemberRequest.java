package com.shivam.projects.lovable_clone.dto.auth.member;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotBlank String username,
        @NotNull ProjectRole projectRole
) {
}
