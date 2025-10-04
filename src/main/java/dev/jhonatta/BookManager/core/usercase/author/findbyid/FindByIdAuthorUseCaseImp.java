package dev.jhonatta.BookManager.core.usercase.author.findbyid;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

public class FindByIdAuthorUseCaseImp implements FindByIdAuthorUseCase{

    private final AuthorGateway authorGateway;

    public FindByIdAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public Author execute(Long id) {
        return authorGateway.findById(id);
    }
}
