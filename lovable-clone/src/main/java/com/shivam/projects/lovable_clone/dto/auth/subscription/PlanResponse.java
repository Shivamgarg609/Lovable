package com.shivam.projects.lovable_clone.dto.auth.subscription;

import java.time.Instant;

public record PlanResponse(
        Long id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Boolean unlimitedAi,
        String price) {
}
