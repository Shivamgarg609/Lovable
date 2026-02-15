package com.shivam.projects.lovable_clone.dto.auth.chat;

import com.shivam.projects.lovable_clone.enumm.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
