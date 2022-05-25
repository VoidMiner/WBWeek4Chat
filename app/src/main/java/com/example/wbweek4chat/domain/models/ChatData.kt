package com.example.wbweek4chat.domain.models

data class ChatData(

    var id: Int,
    val name: String,
    val iconUrl: String,
    val lastMessage: String,
    val date: String,
    val quantityUnreadMessages: String,

    )