package com.example.wbweek4chat.domain.models

data class Chats(
    val chatId: Int,
    val messages: MutableList<ChatMessage>? =null //лучше так не хранить данные, но это тест
)
