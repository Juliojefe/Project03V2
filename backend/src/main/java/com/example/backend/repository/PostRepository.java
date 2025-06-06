package com.example.backend.repository;

import com.example.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Integer> {
}