package dev.jhonatta.BookManager.infrastructure.mappers;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.infrastructure.persistence.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;

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
