package dev.jhonatta.BookManager.core.usercase.category.delete;

import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

public class DeleteCategoryUseCaseImp implements DeleteCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public DeleteCategoryUseCaseImp(CategoryGateway categoryGateway) {

        this.categoryGateway = categoryGateway;
    }

    @Override
    public void execute(Long id) throws CategoryNotFoundException {
        categoryGateway.deleteCategory(id);
    }
}
