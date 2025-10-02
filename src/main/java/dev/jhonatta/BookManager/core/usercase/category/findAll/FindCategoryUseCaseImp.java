package dev.jhonatta.BookManager.core.usercase.category.findAll;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.gateway.CategoryGateway;

import java.util.List;

public class FindCategoryUseCaseImp implements FindCategoryUseCase{

    private final CategoryGateway categoryGateway;

    @Override
    public List<Category> execute() {
        return categoryGateway.findAllCategory();
    }

    public FindCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
}
