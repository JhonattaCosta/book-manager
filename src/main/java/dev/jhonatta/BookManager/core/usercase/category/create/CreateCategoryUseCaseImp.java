package dev.jhonatta.BookManager.core.usercase.category.create;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

public class CreateCategoryUseCaseImp implements CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public CreateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Category category) {
        return categoryGateway.createCategory(category);
    }
}
