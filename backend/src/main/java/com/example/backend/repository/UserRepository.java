package com.example.backend.repository;

import com.example.backend.enums.UserType;
import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}