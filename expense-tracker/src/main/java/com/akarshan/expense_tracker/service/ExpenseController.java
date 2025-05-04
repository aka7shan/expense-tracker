// src/main/java/com/akarshan/expense_tracker/controller/ExpenseController.java
package com.akarshan.expense_tracker.controller;

import com.akarshan.expense_tracker.dto.ExpenseRequest;
import com.akarshan.expense_tracker.dto.ExpenseResponse;
import com.akarshan.expense_tracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseResponse> createExpense(
            @RequestBody ExpenseRequest request
    ) {
        return ResponseEntity.ok(expenseService.createExpense(request));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
}