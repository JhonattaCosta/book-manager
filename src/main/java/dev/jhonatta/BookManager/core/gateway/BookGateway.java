package dev.jhonatta.BookManager.core.gateway;

import dev.jhonatta.BookManager.core.entities.Book;

import java.util.List;

public interface BookGateway {

    Book createBook (Book book);

    List<Book> findAll ();

}
