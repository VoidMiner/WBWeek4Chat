package com.example.wbweek4chat.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.wbweek4chat.domain.models.ChatData


class ChatsDiffUtil: DiffUtil.ItemCallback<ChatData>() {//изменение позиции, сравнение id
    override fun areItemsTheSame(oldItem: ChatData, newItem: ChatData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ChatData, newItem: ChatData): Boolean {
        return oldItem == newItem
    }
}