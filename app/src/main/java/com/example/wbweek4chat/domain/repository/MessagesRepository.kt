package com.example.wbweek4chat.domain.repository

import com.example.wbweek4chat.domain.models.ChatMessage
import com.example.wbweek4chat.domain.models.Chats

interface MessagesRepository {

    fun getMessages(chatId:Int) : List<ChatMessage>//проблемы с отображением отправленных

    fun addNewChatWithId(chatId:Int)

    fun addNewMessage(chatId: Int,message: ChatMessage):Boolean//для статуса отправки

    fun getChatById(chatId:Int): Chats?

}