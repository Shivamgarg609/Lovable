package com.shivam.projects.lovable_clone.dto.auth.member;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole projectRole) {
}
