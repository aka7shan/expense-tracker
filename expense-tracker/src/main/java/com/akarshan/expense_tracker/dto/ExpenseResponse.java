// src/main/java/com/akarshan/expense_tracker/dto/ExpenseResponse.java
package com.akarshan.expense_tracker.dto;

import com.akarshan.expense_tracker.model.ExpenseCategory;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponse {
    private Long id;
    private String description;
    private Double amount;
    private LocalDate date;
    private ExpenseCategory category;
}