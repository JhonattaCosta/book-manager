package dev.jhonatta.BookManager.core.usercase.category.findAll;

import dev.jhonatta.BookManager.core.entities.Category;

import java.util.List;

public interface FindCategoryUseCase {
   public List<Category> execute();

}
