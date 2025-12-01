package com.shivam.projects.lovable_clone.dto.auth.subscription;

import java.time.Instant;

public record PlanResponse(String name,
        String stripePriceId,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Integer maxPreviews,
        Boolean unlimitedAi,
        Boolean active,
        Instant createdAt,
        Instant updatedAt) {
}
