package dev.jhonatta.BookManager.core.usercase.author.findbyid;

import dev.jhonatta.BookManager.core.entities.Author;

public interface FindByIdAuthorUseCase {

    public Author execute (Long id);

}
