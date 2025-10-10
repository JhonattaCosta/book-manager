package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.exceptions.EntityNotFoundException;
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
        return mapper.toDomain(repository.save(mapper.toEntity(author)));
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Author findById(Long id) {
        Optional<AuthorEntity> entity = repository.findById(id);
        AuthorEntity findAuthor = entity.orElseThrow(()->
                new EntityNotFoundException("Author Não encontrado com ID: " + id)
                );
        return mapper.toDomain(findAuthor);
    }

    @Override
    public Author update(Long id, Author author) {
        Optional<AuthorEntity> entityOpt = repository.findById(id);
        AuthorEntity findAuthor = entityOpt.orElseThrow(()->
                new EntityNotFoundException("Author Não encontrado com ID: " + id)
                );
        if (entityOpt.isPresent()){
            AuthorEntity entity = entityOpt.get();
            if (author.name() != null && !author.name().isBlank()){
                entity.setName(author.name());
            }
            AuthorEntity authorSave = repository.save(entity);
            return mapper.toDomain(authorSave);
        }
        return mapper.toDomain(findAuthor);
    }

    @Override
    public void delete(Long id) {
        AuthorEntity entity = repository.findById(id)
                .orElseThrow(()->
                        new EntityNotFoundException("Author Não encontrado com ID: " + id)
                );
        repository.delete(entity);
    }

    @Override
    public boolean existByName(String name) {
        return repository.findAll().stream()
                .anyMatch(author -> author.getName().equalsIgnoreCase(name));
    }
}
