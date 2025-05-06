package com.example.backend.controller;

import com.example.backend.dto.MessageDTO;
import com.example.backend.model.Message;
import com.example.backend.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/chat/{chatId}/")
    public List<MessageDTO> getChatMessages(@PathVariable int chatId) {
        return messageService.getChatMessages(chatId);
    }

    @PostMapping()
    public int sendMessage(@RequestParam String content, @RequestParam int userId, @RequestParam int chatId) {
        return messageService.sendNewMessage(content, userId, chatId);
    }

    @PatchMapping("/{messageId}")
    public boolean editMessage(@PathVariable int messageId, @RequestParam String newContent) {
        return messageService.editMessage(messageId, newContent);
    }

    @DeleteMapping("/{messageId}")
    public boolean deleteMessage(@PathVariable int messageId) {
        return messageService.deleteMessage(messageId);
    }

    @PostMapping("/with-image")
    public int sendMessageWithImage(@RequestParam String content, @RequestParam int userId, @RequestParam int chatId, @RequestParam String imageUrl) {
        return messageService.sendNewMessageWithImage(content, userId, chatId, imageUrl);
    }

}