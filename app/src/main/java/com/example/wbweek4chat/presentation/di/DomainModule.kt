package com.example.wbweek4chat.presentation.di

import com.example.wbweek4chat.domain.repository.ChatsDataRepository
import com.example.wbweek4chat.domain.repository.MessagesRepository
import com.example.wbweek4chat.domain.usecases.AddChatsUseCase
import com.example.wbweek4chat.domain.usecases.AddMessagesUseCase
import com.example.wbweek4chat.domain.usecases.GetChatsUseCase
import com.example.wbweek4chat.domain.usecases.GetMessagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetChatsUseCase(dataRepository: ChatsDataRepository) : GetChatsUseCase {
        return GetChatsUseCase(dataRepository = dataRepository)
    }

    @Provides
    fun provideAddChatsUseCase(dataRepository: ChatsDataRepository, messagesRepository: MessagesRepository) : AddChatsUseCase {
        return AddChatsUseCase(dataRepository, messagesRepository)
    }

    @Provides
    fun provideAddMessages(messagesRepository: MessagesRepository) : AddMessagesUseCase {
        return AddMessagesUseCase(messagesRepository)
    }

    @Provides
    fun provideGetMessagesUseCase(messagesRepository: MessagesRepository) : GetMessagesUseCase {
        return GetMessagesUseCase(messagesRepository)
    }

}