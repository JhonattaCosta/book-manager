package dev.jhonatta.BookManager.core.usercase.book.findall;

import dev.jhonatta.BookManager.core.entities.Book;

import java.util.List;

public interface FindAllBookUseCase {

    public List<Book> execute ();

}
