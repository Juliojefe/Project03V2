package com.example.backend.repository;

import com.example.backend.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Optional<Chat> findByUserOneIdAndUserTwoId(int userOneId, int userTwoId);

    @Query("SELECT c FROM Chat c WHERE c.userOneId = :userId OR c.userTwoId = :userId")
    List<Chat> findChatsByUserId(@Param("userId") int userId);

    Optional<Chat> findByChatId(int chatId);
}