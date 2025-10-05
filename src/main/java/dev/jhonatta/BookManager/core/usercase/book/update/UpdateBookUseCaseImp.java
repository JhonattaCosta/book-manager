package dev.jhonatta.BookManager.core.usercase.book.update;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.gateway.BookGateway;

public class UpdateBookUseCaseImp implements UpdateBookUseCase{

    private final BookGateway bookGateway;

    public UpdateBookUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public Book execute(Long id, Book book) {
        return bookGateway.updateBook(id,book);
    }
}
