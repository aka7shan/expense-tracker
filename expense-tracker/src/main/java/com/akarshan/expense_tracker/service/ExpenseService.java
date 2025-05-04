// src/main/java/com/akarshan/expense_tracker/service/ExpenseService.java
package com.akarshan.expense_tracker.service;

import com.akarshan.expense_tracker.dto.ExpenseRequest;
import com.akarshan.expense_tracker.dto.ExpenseResponse;
import com.akarshan.expense_tracker.model.Expense;
import com.akarshan.expense_tracker.model.User;
import com.akarshan.expense_tracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseResponse createExpense(ExpenseRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        Expense expense = Expense.builder()
                .description(request.getDescription())
                .amount(request.getAmount())
                .date(request.getDate())
                .category(request.getCategory())
                .user(currentUser)
                .build();

        Expense savedExpense = expenseRepository.save(expense);

        return mapToExpenseResponse(savedExpense);
    }

    public List<ExpenseResponse> getAllExpenses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return expenseRepository.findByUser(currentUser)
                .stream()
                .map(this::mapToExpenseResponse)
                .toList();
    }

    private ExpenseResponse mapToExpenseResponse(Expense expense) {
        return ExpenseResponse.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .category(expense.getCategory())
                .build();
    }
}