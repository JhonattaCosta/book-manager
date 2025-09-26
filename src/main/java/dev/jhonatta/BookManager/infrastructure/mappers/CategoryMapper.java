package dev.jhonatta.BookManager.infrastructure.mappers;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.infrastructure.dtos.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO toDto(Category category) {
        return new CategoryDTO(
                category.id(),
                category.name()
        );
    }

    public Category toEntity(CategoryDTO categoryDTO) {
        return new Category(
                categoryDTO.id(),
                categoryDTO.name()
        );
    }

}
