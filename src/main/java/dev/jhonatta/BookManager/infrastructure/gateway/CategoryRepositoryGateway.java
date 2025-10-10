package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.EntityNotFoundException;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;
import dev.jhonatta.BookManager.infrastructure.mappers.category.CategoryEntityMapper;
import dev.jhonatta.BookManager.infrastructure.persistence.category.CategoryEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryGateway implements CategoryGateway {

    private final CategoryRepository repository;
    private final CategoryEntityMapper mapper;

    @Override
    public Category createCategory(Category category) {
        return mapper.toDomain(repository.save(mapper.toEntity(category)));
    }

    @Override
    public List<Category> findAllCategory() {
       return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Category findByIdCategory(Long id) {
        Optional<CategoryEntity> entity = repository.findById(id);
        CategoryEntity findCategory = entity.orElseThrow(()->
                new EntityNotFoundException("Categoria não encontrada com ID: " + id)
        );
        return mapper.toDomain(findCategory);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<CategoryEntity> entityOpt = repository.findById(id);
        CategoryEntity findCategory = entityOpt.orElseThrow(()->
                new EntityNotFoundException("Categoria não encontrada com ID: " + id)
        );
        if(entityOpt.isPresent()){
            CategoryEntity entity = entityOpt.get();
            if (category.name() != null && !category.name().isBlank()){
                entity.setName(category.name());
            }
            CategoryEntity updatedCategory = repository.save(entity);
            return mapper.toDomain(updatedCategory);
        }
        return mapper.toDomain(findCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryEntity entity = repository.findById(id)
        .orElseThrow(()->
                new EntityNotFoundException("Categoria não encontrada com ID: " + id)
        );
        repository.delete(entity);
    }

    @Override
    public boolean existByName(String name) {
        return repository.findAll().stream()
                .anyMatch(category -> category.getName().equalsIgnoreCase(name));
    }
}

