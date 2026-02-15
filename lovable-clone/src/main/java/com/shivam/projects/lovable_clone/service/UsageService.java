package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.subscription.PlanLimitsResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.UsageTodayResponse;

public interface UsageService {
    void recordTokenUsage(Long userId, int actualTokens);
    void checkDailyTokensUsage();
}
