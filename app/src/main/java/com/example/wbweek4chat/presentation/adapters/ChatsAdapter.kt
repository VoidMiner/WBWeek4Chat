package com.example.wbweek4chat.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter
import com.example.wbweek4chat.domain.models.ChatData
import com.example.wbweek4chat.databinding.ChatItemBinding



class ChatsAdapter : ListAdapter<ChatData, ChatsViewHolder>(ChatsDiffUtil()) {
    var onChatClickListener: ((ChatData)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder {
        return ChatsViewHolder(
            ChatItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener() {
            onChatClickListener?.invoke(item)
        }
    }

}