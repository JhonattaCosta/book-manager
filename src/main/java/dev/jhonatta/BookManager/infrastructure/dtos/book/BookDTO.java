package dev.jhonatta.BookManager.infrastructure.dtos.book;
import dev.jhonatta.BookManager.infrastructure.dtos.author.AuthorDTO;
import dev.jhonatta.BookManager.infrastructure.dtos.category.CategoryDTO;

import java.time.LocalDateTime;
import java.util.List;

public record BookDTO (Long id,
        String name,
        String description,
        LocalDateTime releaseDay,
        String identifier,
        List<CategoryDTO> categories,
        List<AuthorDTO> author){
}
