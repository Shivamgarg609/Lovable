package com.shivam.projects.lovable_clone.service;

import com.shivam.projects.lovable_clone.dto.auth.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
