package com.example.wbweek4chat.presentation.di

import com.example.wbweek4chat.data.ChatsDataRepositoryImpl
import com.example.wbweek4chat.data.MessagesRepositoryImpl
import com.example.wbweek4chat.domain.repository.ChatsDataRepository
import com.example.wbweek4chat.domain.repository.MessagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton //соаздние единственного объекта
    fun provideChatsRepository(): ChatsDataRepository {//создание ChatsDataRepository
        return ChatsDataRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideMessagesRepository(): MessagesRepository {//оздание MessagesRepository
        return MessagesRepositoryImpl()
    }

}