package com.example.backend.repository;

import com.example.backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> getMessagesByChatId(int chatId);
}