// src/main/java/com/akarshan/expense_tracker/repository/UserRepository.java
package com.akarshan.expense_tracker.repository;

import com.akarshan.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}