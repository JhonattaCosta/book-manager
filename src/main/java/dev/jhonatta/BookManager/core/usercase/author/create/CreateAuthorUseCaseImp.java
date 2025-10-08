package dev.jhonatta.BookManager.core.usercase.author.create;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.exceptions.DuplicateNameException;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

public class CreateAuthorUseCaseImp implements CreateAuthorUseCase{

    private final AuthorGateway authorGateway;

    public CreateAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public Author execute(Author author) {
        if(authorGateway.existByName(author.name())){
            throw new DuplicateNameException(
                  "Author com nome: " + author.name()   + " Já existe!"
            );
        }
        return authorGateway.createAuthor(author);
    }
}
