// src/main/java/com/akarshan/expense_tracker/dto/AuthenticationResponse.java
package com.akarshan.expense_tracker.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
}