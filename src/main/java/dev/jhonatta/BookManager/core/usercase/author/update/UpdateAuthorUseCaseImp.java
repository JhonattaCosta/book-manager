package dev.jhonatta.BookManager.core.usercase.author.update;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.exceptions.DuplicateNameException;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

public class UpdateAuthorUseCaseImp implements UpdateAuthorUseCase{

    private final AuthorGateway authorGateway;

    public UpdateAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public Author execute(Long id, Author author) {
        if(authorGateway.existByName(author.name())){
            throw new DuplicateNameException(
                    "Author com nome: " + author.name() + " Já existe!"
            );
        }
        return authorGateway.update(id, author);
    }
}
