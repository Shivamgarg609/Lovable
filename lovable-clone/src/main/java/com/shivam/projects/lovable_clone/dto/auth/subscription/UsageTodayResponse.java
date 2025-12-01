package com.shivam.projects.lovable_clone.dto.auth.subscription;

public record UsageTodayResponse(int tokenUsed, int tokenLimit, int previewRunning, int previewLimit) {
}
