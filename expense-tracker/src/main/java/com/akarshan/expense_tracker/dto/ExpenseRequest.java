// src/main/java/com/akarshan/expense_tracker/dto/ExpenseRequest.java
package com.akarshan.expense_tracker.dto;

import com.akarshan.expense_tracker.model.ExpenseCategory;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
    @NotBlank(message = "Description is required")
    private String description;

    @Positive(message = "Amount must be positive")
    @NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Category is required")
    private ExpenseCategory category;
}