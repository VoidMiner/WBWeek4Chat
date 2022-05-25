package com.example.wbweek4chat.domain.usecases

import com.example.wbweek4chat.domain.models.ChatMessage
import com.example.wbweek4chat.domain.repository.MessagesRepository

class AddMessagesUseCase(private val messagesRepository: MessagesRepository) {
    fun  addMessage(chatId: Int, message: ChatMessage):Boolean{
        return messagesRepository.addNewMessage(chatId= chatId, message=message)
    }
}