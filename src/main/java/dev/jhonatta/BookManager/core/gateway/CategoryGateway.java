package dev.jhonatta.BookManager.core.gateway;

import dev.jhonatta.BookManager.core.entities.Category;

import java.util.List;

public interface CategoryGateway {

    Category createCategory(Category category);

    List<Category> findAllCategory();

    Category findByIdCategory(Long id);

}

