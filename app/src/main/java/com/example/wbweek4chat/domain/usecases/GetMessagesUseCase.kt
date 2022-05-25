package com.example.wbweek4chat.domain.usecases

import com.example.wbweek4chat.domain.models.ChatMessage
import com.example.wbweek4chat.domain.repository.MessagesRepository

class GetMessagesUseCase(private val repository: MessagesRepository) {
    fun getMessages(chatId: Int) : List<ChatMessage> {
        return repository.getMessages(chatId)
    }
}