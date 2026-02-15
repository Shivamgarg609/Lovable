package com.shivam.projects.lovable_clone.dto.auth.project;

import com.shivam.projects.lovable_clone.enumm.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role) {
}
