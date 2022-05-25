package com.example.wbweek4chat.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wbweek4chat.databinding.FragmentMessagesBinding
import com.example.wbweek4chat.presentation.adapters.MessagesAdapter
import com.example.wbweek4chat.presentation.viewmodels.MessagesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MessagesFragment : Fragment() {

    private lateinit var binding: FragmentMessagesBinding

    private val viewModel: MessagesViewModel by viewModels()
    private var messagesAdapter = MessagesAdapter()

    private lateinit var name: String
    private var chatId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMessagesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val bundle = MessagesFragmentArgs.fromBundle(requireArguments())

        chatId = bundle.chatId
        name = bundle.name

        observeMessages()
        refreshMessages()
        fillChats()
    }

    private fun observeMessages() {
        viewModel.messages.observe(viewLifecycleOwner) {
            messagesAdapter.submitList(it)
            Log.e("TAG", it.toString())
        }
    }

    private fun fillChats() {
        binding.sendBtn.setOnClickListener() {
            sendMessage()
        }
        binding.chatName.text = name
    }

    private fun sendMessage() {
        viewModel.addMessage(
            chatId = chatId!!,
            text = binding.editTextTextPersonName.text.toString(),
            time = "00:00",
            userId = 0
        )
    }

    private fun refreshMessages() {

        viewModel.loadMessages(chatId!!)

        binding.refreshLayout.setOnRefreshListener {
            viewModel.loadMessages(chatId!!)
            binding.refreshLayout.isRefreshing = false//убрает бесконечное кручение
        }
    }

    private fun setupRecyclerView() {
        binding.messagesRV.apply {
            adapter = messagesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

}