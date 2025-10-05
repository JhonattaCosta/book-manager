package dev.jhonatta.BookManager.core.usercase.book.findyname;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.gateway.BookGateway;

import java.util.List;

public class FindByNameUseCaseImp implements FindByNameUseCase{

    private final BookGateway bookGateway;

    public FindByNameUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public List<Book> execute(String name) {
        return bookGateway.findByName(name);
    }
}
