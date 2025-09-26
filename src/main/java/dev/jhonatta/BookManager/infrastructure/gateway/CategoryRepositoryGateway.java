package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;
import dev.jhonatta.BookManager.infrastructure.mappers.CategoryEntityMapper;
import dev.jhonatta.BookManager.infrastructure.persistence.CategoryEntity;
import dev.jhonatta.BookManager.infrastructure.presentation.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryGateway implements CategoryGateway {

    private final CategoryRepository repository;
    private final CategoryEntityMapper mapper;

    @Override
    public Category createCategory(Category category) {
        CategoryEntity entity = mapper.toEntity(category);
        CategoryEntity newCategory = repository.save(entity);
        return mapper.toDomain(newCategory);

    }

    @Override
    public List<Category> findAllCategory() {
       return repository.findAll().stream().map(mapper::toDomain).toList();
    }
}
