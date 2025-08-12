package dev.jhonatta.BookManager.core.entities;

import java.time.LocalDate;

public record BookLoan(Long id,
                       Book book,
                       LocalDate startDate,
                       LocalDate endDate,
                       Boolean status) {
}
