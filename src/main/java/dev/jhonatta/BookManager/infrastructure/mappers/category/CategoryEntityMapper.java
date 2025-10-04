package dev.jhonatta.BookManager.infrastructure.mappers.category;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.infrastructure.persistence.category.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityMapper {

    public CategoryEntity toEntity(Category category) {
        return new CategoryEntity(
                category.id(),
                category.name()
        );
    }

    public Category toDomain(CategoryEntity categoryEntity){
        return new Category(
                categoryEntity.getId(),
                categoryEntity.getName()
        );
    }

}
