package dev.jhonatta.BookManager.core.usercase.category.create;

import dev.jhonatta.BookManager.core.entities.Category;

public interface CreateCategoryUseCase {
    public Category execute(Category category);

}