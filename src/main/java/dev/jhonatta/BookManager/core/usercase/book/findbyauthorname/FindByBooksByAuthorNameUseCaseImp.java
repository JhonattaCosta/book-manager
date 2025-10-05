package dev.jhonatta.BookManager.core.usercase.book.findbyauthorname;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.gateway.BookGateway;

import java.util.List;

public class FindByBooksByAuthorNameUseCaseImp implements FindByBooksByAuthorNameUseCase {

    private final BookGateway bookGateway;

    public FindByBooksByAuthorNameUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public List<Book> execute(String authorName) {
        return bookGateway.findByAuthorName(authorName);
    }
}
