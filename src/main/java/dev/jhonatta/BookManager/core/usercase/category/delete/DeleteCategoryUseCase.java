package dev.jhonatta.BookManager.core.usercase.category.delete;

import dev.jhonatta.BookManager.core.exceptions.EntityNotFoundException;

public interface DeleteCategoryUseCase {

    void execute(Long id) throws EntityNotFoundException;
}
