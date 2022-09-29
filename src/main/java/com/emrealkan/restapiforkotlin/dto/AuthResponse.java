package com.emrealkan.restapiforkotlin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String authToken;
    private String userName;
    private String email;
    private Instant expiresAt;
    private String role;
}
