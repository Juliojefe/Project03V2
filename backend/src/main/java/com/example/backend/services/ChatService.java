package com.example.backend.services;

import com.example.backend.model.Chat;
import com.example.backend.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public int createChat(int userOneId, int userTwoId) {
        Chat newChat = new Chat(userOneId, userTwoId);
        chatRepository.save(newChat);
        return newChat.getChatId();
    }

    public boolean deleteChatById(int chatId) {
        Optional<Chat> chatOptional = chatRepository.findByChatId(chatId);
        if (chatOptional.isPresent()) {
            chatRepository.delete(chatOptional.get());
            return true;
        }
        return false;
    }

    public List<Chat> findUserChats(int userId) {
        return chatRepository.findChatsByUserId(userId);
    }

    public boolean changeChatName(int chatId, String newName) {
        Optional<Chat> chatOptional = chatRepository.findByChatId(chatId);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            chat.setName(newName);
            chatRepository.save(chat);
            return true;
        }
        return false;
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
}
