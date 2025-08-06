package dev.jhonatta.BookManager.core.entities;

import java.time.LocalDate;
import java.util.List;

public record Books(Long id,
                    String name,
                    String description,
                    LocalDate releaseDay,
                    Authors authors,
                    List<Category> categories) {
}
