package dev.jhonatta.BookManager.core.usercase.author.update;

import dev.jhonatta.BookManager.core.entities.Author;

public interface UpdateAuthorUseCase {

    public Author execute (Long id, Author author);

}
