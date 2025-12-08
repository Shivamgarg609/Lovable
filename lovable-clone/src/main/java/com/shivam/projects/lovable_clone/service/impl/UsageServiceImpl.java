package com.shivam.projects.lovable_clone.service.impl;

import com.shivam.projects.lovable_clone.dto.auth.subscription.PlanLimitsResponse;
import com.shivam.projects.lovable_clone.dto.auth.subscription.UsageTodayResponse;
import com.shivam.projects.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getPlanLimitsOfUser(Long userId) {
        return null;
    }
}
