// src/main/java/com/akarshan/expense_tracker/dto/RegisterRequest.java
package com.akarshan.expense_tracker.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Firstname is required")
    private String firstname;

    @NotBlank(message = "Lastname is required")
    private String lastname;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 6, message = "Password should be at least 6 characters")
    @NotBlank(message = "Password is required")
    private String password;
}