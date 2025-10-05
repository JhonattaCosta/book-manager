package dev.jhonatta.BookManager.core.usercase.book.findyname;

import dev.jhonatta.BookManager.core.entities.Book;

import java.util.List;

public interface FindByNameUseCase {

    public List<Book> execute (String name);

}
