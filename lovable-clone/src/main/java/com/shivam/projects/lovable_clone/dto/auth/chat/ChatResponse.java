package com.shivam.projects.lovable_clone.dto.auth.chat;

import com.shivam.projects.lovable_clone.entity.ChatEvent;
import com.shivam.projects.lovable_clone.entity.ChatSession;
import com.shivam.projects.lovable_clone.enumm.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt

) {
}
