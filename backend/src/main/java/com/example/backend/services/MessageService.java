package com.example.backend.services;

import com.example.backend.dto.MessageDTO;
import com.example.backend.enums.RelatedType;
import com.example.backend.model.Image;
import com.example.backend.model.Message;
import com.example.backend.repository.ImageRepository;
import com.example.backend.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ImageRepository imageRepository;

    public int sendNewMessage(String content, int userId, int chatId) {
        Message message = new Message(content, userId, chatId);
        messageRepository.save(message);
        return message.getMessageId();
    }

    @Transactional
    public int sendNewMessageWithImage(String content, int userId, int chatId, String imageUrl) {
//        Message message = new Message(content, userId, chatId);
//        messageRepository.save(message);
        int messageId = sendNewMessage(content, userId, chatId);
        Image image = new Image();
        image.setImageUrl(imageUrl);
        image.setRelatedType(RelatedType.message);
        image.setRelatedId(messageId);
        imageRepository.save(image);
        return messageId;
    }

    public List<MessageDTO> getChatMessages(int chatId) {
        List<Message> messages = messageRepository.getMessagesByChatId(chatId);
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Message message : messages) {
            MessageDTO dto = new MessageDTO();
            dto.setMessageId(message.getMessageId());
            dto.setContent(message.getContent());
            dto.setUserId(message.getUserId());
            dto.setChatId(message.getChatId());
            dto.setCreatedAt(message.getCreatedAt());
            dto.setImages(imageRepository.findByRelatedIdAndRelatedType(message.getMessageId(), RelatedType.message));
            messageDTOs.add(dto);
        }
        return messageDTOs;
    }

    public List<MessageDTO> getAllMessages() {
        List<Message> messages = messageRepository.findAll();
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Message message : messages) {
            MessageDTO dto = new MessageDTO();
            dto.setMessageId(message.getMessageId());
            dto.setContent(message.getContent());
            dto.setUserId(message.getUserId());
            dto.setChatId(message.getChatId());
            dto.setCreatedAt(message.getCreatedAt());
            dto.setImages(imageRepository.findByRelatedIdAndRelatedType(message.getMessageId(), RelatedType.message));
            messageDTOs.add(dto);
        }
        return messageDTOs;
    }

    public boolean deleteMessage(int messageId) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if (messageOptional.isPresent()) {
            imageRepository.deleteByRelatedIdAndRelatedType(messageId, RelatedType.message);
            messageRepository.delete(messageOptional.get());
            return true;
        }
        return false;
    }

    public boolean editMessage(int messageId, String newContents) {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setContent(newContents);
            messageRepository.save(message);
            return true;
        }
        return false;
    }
}
