// src/main/java/com/akarshan/expense_tracker/repository/ExpenseRepository.java
package com.akarshan.expense_tracker.repository;

import com.akarshan.expense_tracker.model.Expense;
import com.akarshan.expense_tracker.model.ExpenseCategory;
import com.akarshan.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
    List<Expense> findByUserAndCategory(User user, ExpenseCategory category);
}