package com.example.wbweek4chat.domain.usecases

import com.example.wbweek4chat.domain.models.ChatData
import com.example.wbweek4chat.domain.repository.ChatsDataRepository


class GetChatsUseCase(private val dataRepository: ChatsDataRepository) {

    fun getChats() : List<ChatData> {
        return dataRepository.getChats()
    }

}