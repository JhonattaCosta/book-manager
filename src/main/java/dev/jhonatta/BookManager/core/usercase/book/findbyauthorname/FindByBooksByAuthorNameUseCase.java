package dev.jhonatta.BookManager.core.usercase.book.findbyauthorname;

import dev.jhonatta.BookManager.core.entities.Book;

import java.util.List;

public interface FindByBooksByAuthorNameUseCase {

    List<Book> execute(String authorName);

}
