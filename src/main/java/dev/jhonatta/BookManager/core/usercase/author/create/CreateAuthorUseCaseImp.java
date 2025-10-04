package dev.jhonatta.BookManager.core.usercase.author.create;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

public class CreateAuthorUseCaseImp implements CreateAuthorUseCase{

    private final AuthorGateway authorGateway;

    public CreateAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public Author execute(Author author) {
        return authorGateway.createAuthor(author);
    }
}
