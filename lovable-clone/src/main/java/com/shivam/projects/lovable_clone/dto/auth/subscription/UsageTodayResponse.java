package com.shivam.projects.lovable_clone.dto.auth.subscription;

public record UsageTodayResponse(Integer tokenUsed, Integer tokenLimit, Integer previewRunning, Integer previewLimit) {
}
