package dev.jhonatta.BookManager.core.usercase.author.update;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

public class UpdateAuthorUseCaseImp implements UpdateAuthorUseCase{

    private final AuthorGateway authorGateway;

    public UpdateAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public Author execute(Long id, Author author) {
        return authorGateway.update(id, author);
    }
}
