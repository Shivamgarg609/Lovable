package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.subscription.PlanLimitsResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getPlanLimitsOfUser(Long userId);
}
