package dev.jhonatta.BookManager.infrastructure.mappers.book;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.infrastructure.dtos.book.BookDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.author.AuthorMapper;
import dev.jhonatta.BookManager.infrastructure.mappers.category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class BookMapper {

    private final CategoryMapper categoryMapper;
    private final AuthorMapper authorMapper;

    public BookDTO toDto(Book book) {

        return new BookDTO(
                book.id(),
                book.name(),
                book.description(),
                book.releaseDay(),
                book.identifier(),
                book.categories() != null
                        ? book.categories().stream()
                        .map(categoryMapper::toDto)
                        .collect(Collectors.toList())
                        : List.of(),
                book.author() != null
                        ? book.author().stream()
                        .map(authorMapper::toDto)
                        .collect(Collectors.toList())
                        : List.of()
        );
    }

    public Book toEntity(BookDTO bookDTO) {
        return new Book(
                bookDTO.id(),
                bookDTO.name(),
                bookDTO.description(),
                bookDTO.releaseDay(),
                bookDTO.identifier(),
                bookDTO.categories() != null
                        ? bookDTO.categories().stream()
                        .map(categoryMapper::toEntity)
                        .collect(Collectors.toList())
                        : List.of(),
                bookDTO.author() != null
                        ? bookDTO.author().stream()
                        .map(authorMapper::toEntity)
                        .collect(Collectors.toList())
                        : List.of()
        );
    }
}
