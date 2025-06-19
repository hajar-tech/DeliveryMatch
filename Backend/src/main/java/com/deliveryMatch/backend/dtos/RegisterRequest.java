package com.deliveryMatch.backend.dtos;

public record RegisterRequest(
        String nom,
        String email,
        String password,
        String typeUtilisateur
) {
}
