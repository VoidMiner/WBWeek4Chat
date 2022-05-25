package com.example.wbweek4chat.domain.models

data class ChatMessage(
    var id: Int? = UNDEFINED_ID,
    val text: String,
    val time: String,
    val userId: Int,
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
