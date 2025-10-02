package dev.jhonatta.BookManager.core.usercase.category.update;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;

public interface UpdateCategoryUseCase {
    Category execute (Long id, Category category) throws CategoryNotFoundException;
}
