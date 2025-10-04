package dev.jhonatta.BookManager.core.entities;

import java.time.LocalDateTime;
import java.util.List;

public record Book(Long id, String name, String description, LocalDateTime releaseDay, String identifier, List<Category> categories,Author author) {
}
