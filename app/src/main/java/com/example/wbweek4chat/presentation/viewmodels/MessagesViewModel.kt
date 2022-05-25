package com.example.wbweek4chat.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wbweek4chat.domain.models.ChatMessage
import com.example.wbweek4chat.domain.usecases.AddMessagesUseCase
import com.example.wbweek4chat.domain.usecases.GetMessagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MessagesViewModel @Inject constructor(
    private val getMessagesUseCase: GetMessagesUseCase,
    private val addMessagesUseCase: AddMessagesUseCase
): ViewModel() {

    private val _messages = MutableLiveData<List<ChatMessage>>()
    val messages: LiveData<List<ChatMessage>> = _messages

    fun loadMessages(chatId: Int) {
        _messages.postValue(getMessagesUseCase.getMessages(chatId))
    }

    fun addMessage(chatId: Int, text: String, time: String, userId: Int) {
        val message = ChatMessage(
            text = text,
            time = time,
            userId = userId
        )
        addMessagesUseCase.addMessage(chatId = chatId, message = message)
        loadMessages(chatId)
    }

}