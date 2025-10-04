package dev.jhonatta.BookManager.infrastructure.mappers.author;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.infrastructure.dtos.author.AuthorDTO;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDTO toDto (Author author){
        return new AuthorDTO(
                author.id(),
                author.name()
        );
    }

    public Author toEntity(AuthorDTO authorDTO){
        return new Author(
                authorDTO.id(),
                authorDTO.name()
        );
    }


}
