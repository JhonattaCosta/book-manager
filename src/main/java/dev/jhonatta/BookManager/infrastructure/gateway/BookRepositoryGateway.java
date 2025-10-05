package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.gateway.BookGateway;
import dev.jhonatta.BookManager.infrastructure.mappers.book.BookEntityMapper;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.book.BookEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class BookRepositoryGateway implements BookGateway {

    private final BookRepository repository;
    private final BookEntityMapper mapper;

    @Override
    public Book createBook(Book book) {
        BookEntity entity = mapper.toEntity(book);
        BookEntity entitySave = repository.save(entity);
        return mapper.toDomain(entitySave);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorName(String auhtor) {
        return repository.findBooksByAuthorNameContaining(auhtor).stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
