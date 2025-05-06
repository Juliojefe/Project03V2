package com.example.backend.repository;

import com.example.backend.enums.RelatedType;
import com.example.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ImageRepository extends JpaRepository<Image, Integer> {
    List<Image> findByRelatedIdAndRelatedType(int relatedId, RelatedType relatedType);
    void deleteByRelatedIdAndRelatedType(int relatedId, RelatedType relatedType);
}