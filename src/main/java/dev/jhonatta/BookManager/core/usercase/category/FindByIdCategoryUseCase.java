package dev.jhonatta.BookManager.core.usercase.category;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;

public interface FindByIdCategoryUseCase {

    Category execute (Long id) throws CategoryNotFoundException;

}
