package com.example.backend.repository;

import com.example.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ImageRepository extends JpaRepository<Image, Integer> {
}