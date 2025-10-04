package dev.jhonatta.BookManager.core.usercase.author.findall;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;

import java.util.List;

public class FindAllAuthorUseCaseImp implements FindAllAuthorUseCase{

    private  final AuthorGateway authorGateway;

    public FindAllAuthorUseCaseImp(AuthorGateway authorGateway) {
        this.authorGateway = authorGateway;
    }

    @Override
    public List<Author> execute() {
        return authorGateway.findAll();
    }
}
