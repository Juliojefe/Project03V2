package com.example.backend.controller;

import com.example.backend.model.Chat;
import com.example.backend.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{userId}/")
    List<Chat> findUserChats(@PathVariable int userId) {
        return chatService.findUserChats(userId);
    }

    @PatchMapping("/{chatId}/rename")
    public boolean changeChatName(@PathVariable int chatId, @RequestParam String newName) {
        return chatService.changeChatName(chatId, newName);
    }

    @DeleteMapping("/{chatId}")
    public boolean deleteChatById(@PathVariable int chatId) {
        return chatService.deleteChatById(chatId);
    }

    @PostMapping("/userOneId/{userOneId}/userTwoId/{userTwoId}")
    public int createChat(@PathVariable int userOneId, @PathVariable int userTwoId) {
        return chatService.createChat(userOneId, userTwoId);
    }

    @GetMapping("/")
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }
}
