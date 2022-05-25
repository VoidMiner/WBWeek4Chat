package com.example.wbweek4chat.data

import android.util.Log
import com.example.wbweek4chat.domain.models.ChatMessage
import com.example.wbweek4chat.domain.models.Chats
import com.example.wbweek4chat.domain.repository.MessagesRepository


class MessagesRepositoryImpl : MessagesRepository {

    private val _storageChatsMessages =
        mutableListOf<Chats>(Chats(0, mutableListOf()))


    override fun getMessages(chatId: Int): List<ChatMessage> {
        val chat = getChatById(chatId)
        return chat?.messages ?: listOf()
    }

    override fun addNewChatWithId(chatId: Int) {
        val item = Chats(chatId = chatId, mutableListOf())
        _storageChatsMessages.add(item)
    }

    override fun addNewMessage(chatId: Int, message: ChatMessage): Boolean {
        val chat = getChatById(chatId)
        chat?.messages?.let {
            val messageWithId = message.copy(id = it.size)
            it.add(messageWithId)
            return true
        }
        return false
    }


    override fun getChatById(chatId: Int): Chats? {
        Log.e("TAG", chatId.toString())
        return _storageChatsMessages.find { chat ->
            chat.chatId == chatId
        }

    }
}