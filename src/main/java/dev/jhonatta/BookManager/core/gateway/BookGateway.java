package dev.jhonatta.BookManager.core.gateway;

import dev.jhonatta.BookManager.core.entities.Book;

import java.util.List;

public interface BookGateway {

    Book createBook (Book book);

    List<Book> findAll ();

    List<Book> findByName (String name);

    List<Book> findByAuthorName (String authorName);

    Book updateBook (Long id,Book book);

}
