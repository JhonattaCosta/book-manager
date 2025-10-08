package dev.jhonatta.BookManager.core.usercase.category.findById;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.EntityNotFoundException;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

public class FindByIdCategoryUseCaseImp implements FindByIdCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public FindByIdCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Long id) throws EntityNotFoundException {
        return categoryGateway.findByIdCategory(id);
    }
}
