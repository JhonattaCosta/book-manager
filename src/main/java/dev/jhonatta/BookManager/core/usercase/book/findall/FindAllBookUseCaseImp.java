package dev.jhonatta.BookManager.core.usercase.book.findall;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.gateway.BookGateway;

import java.util.List;

public class FindAllBookUseCaseImp implements FindAllBookUseCase{

    private final BookGateway bookGateway;

    public FindAllBookUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public List<Book> execute() {
        return bookGateway.findAll();
    }
}
