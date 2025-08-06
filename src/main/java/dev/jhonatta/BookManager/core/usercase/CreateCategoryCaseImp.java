package dev.jhonatta.BookManager.core.usercase;

import dev.jhonatta.BookManager.core.entities.Category;

public class CreateCategoryCaseImp implements CreateCategoryCase{

    @Override
    public Category execute(Category category) {
        return new Category(category.id(), category.name());
    }
}
