package com.example.wbweek4chat.domain.usecases

import com.example.wbweek4chat.domain.repository.ChatsDataRepository
import com.example.wbweek4chat.domain.repository.MessagesRepository

class AddChatsUseCase(
    private val chatDataRepository: ChatsDataRepository,
    private val messagesRepository: MessagesRepository
) {
    fun addChat() {
        chatDataRepository.addSomeChats()
        messagesRepository.addNewChatWithId(chatDataRepository.getLastId())
    }
}