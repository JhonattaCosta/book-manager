package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.gateway.AuthorGateway;
import dev.jhonatta.BookManager.infrastructure.mappers.author.AuthorEntityMapper;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorRepositoryGateway implements AuthorGateway {

    private final AuthorRepository repository;
    private final AuthorEntityMapper mapper;

    @Override
    public Author createAuthor(Author author) {
        AuthorEntity entity = mapper.toEntity(author);
        AuthorEntity newEntity = repository.save(entity);
        return mapper.toDomain(newEntity);
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Author findById(Long id) {
        Optional<AuthorEntity> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()){
            AuthorEntity entity = entityOpt.get();
            return mapper.toDomain(entity);
        }
        return null;
    }

}
