package dev.jhonatta.BookManager.core.usercase.category.update;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

public class UpdateCategoryUseCaseImp  implements UpdateCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public UpdateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Long id, Category category) throws CategoryNotFoundException {
        return categoryGateway.updateCategory(id, category);
    }
}
