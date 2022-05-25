package com.example.wbweek4chat.domain.repository

import com.example.wbweek4chat.domain.models.ChatData


interface ChatsDataRepository {

    fun getChats(): List<ChatData>

    fun getChatById(chatId: Int): ChatData

    fun getLastId(): Int

    fun addSomeChats()
}