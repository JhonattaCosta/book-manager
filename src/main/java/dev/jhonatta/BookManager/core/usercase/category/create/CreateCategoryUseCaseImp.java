package dev.jhonatta.BookManager.core.usercase.category.create;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.exceptions.DuplicateNameException;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

public class CreateCategoryUseCaseImp implements CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public CreateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Category category) {
        if(categoryGateway.existByName(category.name())) {
            throw new DuplicateNameException(
                    "O nome: " +category.name() + " Já existe!."
            );
        }

        return categoryGateway.createCategory(category);
    }
}
