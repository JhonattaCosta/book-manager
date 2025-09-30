package dev.jhonatta.BookManager.core.usercase.category;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

import java.util.Optional;

public class FindByIdCategoryUseCaseImp implements FindByIdCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public FindByIdCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Long id) throws CategoryNotFoundException {
        return categoryGateway.findByIdCategory(id);
    }
}
