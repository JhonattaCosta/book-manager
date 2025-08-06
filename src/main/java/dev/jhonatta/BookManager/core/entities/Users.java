package dev.jhonatta.BookManager.core.entities;

import dev.jhonatta.BookManager.core.UserRole;

import java.time.LocalDate;

public record Users(Long id,
                    String name,
                    LocalDate birtDate,
                    String email,
                    String password,
                    LocalDate accountCreation,
                    UserRole userRole) {
    // ENUM DE USUARIO AMD E COMUM
}
