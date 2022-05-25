package com.example.wbweek4chat.presentation.adapters

import com.example.wbweek4chat.domain.models.ChatMessage
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wbweek4chat.databinding.UserMessageRightBinding


class MessagesAdapter :
    ListAdapter<ChatMessage, MessagesAdapter.MessagesViewHolder>(MessagesDiffUtil()) {

    class MessagesViewHolder(private val binding: UserMessageRightBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: ChatMessage) {
            binding.apply {
                text.text = message.text
                username.text = message.userId.toString()
                time.text = message.time
            }
        }
    }

    class MessagesDiffUtil : DiffUtil.ItemCallback<ChatMessage>() {
        override fun areItemsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        return MessagesViewHolder(
            UserMessageRightBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}