package com.shivam.projects.lovable_clone.Mapper;

import com.shivam.projects.lovable_clone.dto.auth.chat.ChatResponse;
import com.shivam.projects.lovable_clone.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
