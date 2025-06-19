package com.deliveryMatch.backend.dtos;

public record LoginRequest(
        String email, String password
) {
}
