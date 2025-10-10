package dev.jhonatta.BookManager.core.gateway;

import dev.jhonatta.BookManager.core.entities.Author;

import java.util.List;

public interface AuthorGateway {

    Author createAuthor (Author author);

    List<Author> findAll ();

    Author findById (Long id);

    Author update (Long id, Author author);

    void delete(Long id);

    boolean existByName(String name);
}
