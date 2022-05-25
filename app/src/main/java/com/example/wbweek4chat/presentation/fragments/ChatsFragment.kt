package com.example.wbweek4chat.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wbweek4chat.R
import com.example.wbweek4chat.databinding.FragmentChatsBinding
import com.example.wbweek4chat.domain.models.ChatData
import com.example.wbweek4chat.presentation.adapters.ChatsAdapter
import com.example.wbweek4chat.presentation.viewmodels.ChatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ChatsViewModel by viewModels()

    private val chatsAdapter = ChatsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeChats()
        refreshChats()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        binding.chatsRecyclerView.apply {
            adapter = chatsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        chatsAdapter.onChatClickListener = {
            val bun = Bundle()
            bun.putInt("chatId", it.id)
            bun.putString("name", it.name)
            Navigation.findNavController(binding.root).navigate(R.id.action_chatsFragment_to_messagesFragment, bun)
        }
    }

    private fun addElementsWithoutAdapter(chats: List<ChatData>) {//3 пункт задания
        binding.linearLayout.removeAllViews()
        for (chat in chats) {
            val layoutId = R.layout.chat_item
            val view = LayoutInflater.from(requireContext()).inflate(layoutId, binding.linearLayout, false)
            val tvName = view.findViewById<TextView>(R.id.name)
            val lastMessage = view.findViewById<TextView>(R.id.lastMessage)
            val unread = view.findViewById<TextView>(R.id.unread)
            val date = view.findViewById<TextView>(R.id.date)
            binding.linearLayout.addView(view)
        }
    }

    private fun observeChats() {
        viewModel.chats.observe(viewLifecycleOwner) {
            chatsAdapter.submitList(it)
            if (it.isNotEmpty()) binding.noChatsTV.isVisible = false
            if (it.isEmpty()) binding.noChatsTV.isVisible = true
//            addElementsWithoutAdapter(it)
        }
    }

    private fun refreshChats() {
        binding.refreshLayout.setOnRefreshListener {
            viewModel.addChat()
            viewModel.loadChats()//загрузка данных из viewmodel
            binding.refreshLayout.isRefreshing = false//убрает бесконечное кручение
        }
    }

}