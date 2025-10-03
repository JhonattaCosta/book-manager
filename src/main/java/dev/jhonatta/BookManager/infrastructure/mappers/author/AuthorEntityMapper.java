package dev.jhonatta.BookManager.infrastructure.mappers.author;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorEntityMapper {

    public AuthorEntity toEntity(Author author){
        return new AuthorEntity(
                author.id(),
                author.name()
        );
    }

    public Author toDomain(AuthorEntity authorEntity){
        return new Author(
                authorEntity.getId(),
                authorEntity.getName()
        );
    }
}
