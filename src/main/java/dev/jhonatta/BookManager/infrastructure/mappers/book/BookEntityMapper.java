package dev.jhonatta.BookManager.infrastructure.mappers.book;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.infrastructure.mappers.author.AuthorEntityMapper;
import dev.jhonatta.BookManager.infrastructure.mappers.category.CategoryEntityMapper;
import dev.jhonatta.BookManager.infrastructure.persistence.book.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookEntityMapper {

    private final CategoryEntityMapper categoryEntityMapper;
    private final AuthorEntityMapper authorEntityMapper;


    public BookEntity toEntity(Book book) {
        return new BookEntity(
                book.id(),
                book.name(),
                book.description(),
                book.releaseDay(),
                book.identifier(),
                book.categories() != null
                        ? book.categories().stream()
                        .map(categoryEntityMapper::toEntity)
                        .collect(Collectors.toList())
                        : List.of(),
                book.author() != null
                        ? book.author().stream()
                        .map(authorEntityMapper::toEntity)
                        .collect(Collectors.toList())
                        : List.of()
        );
    }

    public Book toDomain(BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                bookEntity.getName(),
                bookEntity.getDescription(),
                bookEntity.getReleaseDay(),
                bookEntity.getIdentifier(),
                bookEntity.getCategories() != null
                        ? bookEntity.getCategories().stream()
                        .map(categoryEntityMapper::toDomain)
                        .collect(Collectors.toList())
                        : List.of(),
                bookEntity.getAuthor() != null
                        ? bookEntity.getAuthor().stream()
                        .map(authorEntityMapper::toDomain)
                        .collect(Collectors.toList())
                        : List.of()
        );
    }

}
