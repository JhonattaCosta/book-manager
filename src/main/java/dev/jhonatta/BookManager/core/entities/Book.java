package dev.jhonatta.BookManager.core.entities;

import java.time.LocalDate;
import java.util.List;

public record Book(Long id,
                   String name,
                   String description,
                   LocalDate releaseDay,
                   Author author,
                   List<Category> categories,
                   BookLoan bookLoan) {
}
