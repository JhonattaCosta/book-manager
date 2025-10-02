package dev.jhonatta.BookManager.core.usercase.category.delete;

import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;

public interface DeleteCategoryUseCase {

    void execute(Long id) throws CategoryNotFoundException;
}
