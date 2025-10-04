package dev.jhonatta.BookManager.core.gateway;

import dev.jhonatta.BookManager.core.entities.Author;

import java.util.List;

public interface AuthorGateway {

    Author createAuthor (Author author);

    List<Author> findAll ();

    Author findById (Long id);
}
