package com.example.wbweek4chat.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.wbweek4chat.databinding.ChatItemBinding
import com.example.wbweek4chat.domain.models.ChatData


class ChatsViewHolder(private var binding: ChatItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(chatData: ChatData) {
        binding.apply {
            name.text = chatData.name
            lastMessage.text = chatData.lastMessage
            unread.text = chatData.quantityUnreadMessages
            date.text = chatData.date
            //icon
        }
    }
}