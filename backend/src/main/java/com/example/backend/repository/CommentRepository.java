package com.example.backend.repository;

import com.example.backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
}