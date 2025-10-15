package dev.jhonatta.BookManager.core.usercase.book.identifier;

import dev.jhonatta.BookManager.core.gateway.BookGateway;

public class CreateRandomIdentifierUseCaseImp implements CreateRandomIdentifierUseCase{

    private final BookGateway bookGateway;

    public CreateRandomIdentifierUseCaseImp(BookGateway bookGateway) {
        this.bookGateway = bookGateway;
    }

    @Override
    public String execute() {
        return bookGateway.createRandomIdentifier();
    }
}
