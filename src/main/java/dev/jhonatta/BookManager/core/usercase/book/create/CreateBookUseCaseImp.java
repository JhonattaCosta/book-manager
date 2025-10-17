package dev.jhonatta.BookManager.core.usercase.book.create;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.gateway.BookGateway;

public class CreateBookUseCaseImp implements CreateBookUseCase{

    private final BookGateway bookGateway;

    public CreateBookUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public Book execute(Book book) {
        String identifier;
        do {
            identifier = bookGateway.createRandomIdentifier();
        }while (bookGateway.existByIdentifier(identifier));
        return bookGateway.createBook(book);
    }
}
