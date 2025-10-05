package dev.jhonatta.BookManager.core.usercase.book.delete;

import dev.jhonatta.BookManager.core.gateway.BookGateway;

public class DeleteBookUseCaseImp implements DeleteBookUseCase{

    private final BookGateway bookGateway;

    public DeleteBookUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public void execute(Long id) {
        bookGateway.deleteBook(id);
    }
}
