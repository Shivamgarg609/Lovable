package com.shivam.projects.lovable_clone.dto.auth.subscription;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerday,
        Integer maxProjects,
        Boolean unlimitedAi) {
    // TO add other args
}
