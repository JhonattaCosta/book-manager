package dev.jhonatta.BookManager.core.usercase.book.update;

import dev.jhonatta.BookManager.core.entities.Book;

public interface UpdateBookUseCase {

    public Book execute(Long id, Book book);

}
