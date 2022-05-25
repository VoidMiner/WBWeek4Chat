package com.example.wbweek4chat.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wbweek4chat.domain.usecases.GetChatsUseCase
import com.example.wbweek4chat.domain.models.ChatData
import com.example.wbweek4chat.domain.usecases.AddChatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val getChatsUseCase: GetChatsUseCase,
    private val addChatsUseCase: AddChatsUseCase
): ViewModel() {

    private val _chats = MutableLiveData<List<ChatData>>()
    val chats: LiveData<List<ChatData>> = _chats

    init {
        loadChats()
    }

    fun loadChats() {
        _chats.postValue(getChatsUseCase.getChats())
    }//добавление в _chats чатов из репозитория в фоновом потоке, потому что postValue

    fun addChat() {
        addChatsUseCase.addChat()
    }



}