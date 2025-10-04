package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;
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
        CategoryEntity entity = mapper.toEntity(category);
        CategoryEntity newCategory = repository.save(entity);
        return mapper.toDomain(newCategory);

    }

    @Override
    public List<Category> findAllCategory() {
       return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Category findByIdCategory(Long id) {
        Optional<CategoryEntity> entity = repository.findById(id);
        CategoryEntity findCategory = entity.orElseThrow(()->
                new CategoryNotFoundException("Categoria não encontrada com ID: " + id)
        );
        return mapper.toDomain(findCategory);
    }

    @Override
    public Category updateCategory(Long id, Category category) {

        Optional<CategoryEntity> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()){
            CategoryEntity entity = entityOpt.get();
            if ( category.name() != null ){
               entity.setName(category.name());
            }
            CategoryEntity categorySave = repository.save(entity);
            return mapper.toDomain(categorySave);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}

