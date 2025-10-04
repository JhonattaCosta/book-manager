package dev.jhonatta.BookManager.core.usercase.author.delete;

import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

public class DeleteAuthorUseCaseImp implements DeleteAuthorUseCase{

    private final AuthorGateway authorGateway;

    public DeleteAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public void execute(Long id) {
        authorGateway.delete(id);
    }
}
