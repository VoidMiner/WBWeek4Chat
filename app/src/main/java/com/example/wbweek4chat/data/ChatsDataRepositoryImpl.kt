package com.example.wbweek4chat.data

import com.example.wbweek4chat.domain.repository.ChatsDataRepository
import com.example.wbweek4chat.domain.models.ChatData


class ChatsDataRepositoryImpl: ChatsDataRepository {

    private val _chats = mutableListOf<ChatData>()//изменяемый список
    private var id: Int = 0

        private val randomNames = listOf<String>("Vasya", "Ira", "Andrey", "Katya", "Dima", "Sergey")
        private val randomLastMsg = listOf<String>("Poka", "Heey", "Goodbye", "Good night", "U here?", ":D")
        private val randomTime = listOf<String>("12:32", "11:49", "14:02", "19:24", "01:52", "00:00")
        private val randomUnread = listOf<String>("123", "11", "0", "65", "1", "4")

    override fun getChats(): List<ChatData> {
            return _chats.toList()
        }
    override fun getChatById(chatId: Int): ChatData {
        return _chats.find {
            it.id == chatId
        } ?: throw RuntimeException("Element with id $chatId not found")//если не найдено (null)
    }
    override fun getLastId(): Int {//последний в 10 строке
        return id
    }
    override fun addSomeChats() {//генерация чатов
        val newChat = getRandomChat()
        _chats.add(newChat)
        id++
    }
    private fun getRandomChat(): ChatData {//отобразиь рандом чат
        val size = randomNames.indices
        return ChatData(
            id = id,
            name = randomNames[(size).random()],
            iconUrl = "",
            lastMessage = randomLastMsg[(size).random()],
            date = randomTime[(size).random()],
            quantityUnreadMessages = randomUnread[(size).random()]
        )
    }
}
