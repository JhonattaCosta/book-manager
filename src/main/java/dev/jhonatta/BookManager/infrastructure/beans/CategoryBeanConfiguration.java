package dev.jhonatta.BookManager.infrastructure.beans;

import dev.jhonatta.BookManager.core.gateway.CategoryGateway;
import dev.jhonatta.BookManager.core.usercase.category.create.CreateCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.create.CreateCategoryUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.category.delete.DeleteCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.delete.DeleteCategoryUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.category.findAll.FindCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.findAll.FindCategoryUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.category.findById.FindByIdCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.findById.FindByIdCategoryUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.category.update.UpdateCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.update.UpdateCategoryUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryBeanConfiguration {

    @Bean
    public CreateCategoryUseCase createCategory (CategoryGateway categoryGateway){
        return new CreateCategoryUseCaseImp(categoryGateway);
    }

    @Bean
    public FindCategoryUseCase FindAllCategory (CategoryGateway categoryGateway){
        return new FindCategoryUseCaseImp(categoryGateway);
    }

    @Bean
    public FindByIdCategoryUseCase findByIdCategory (CategoryGateway categoryGateway){
        return new FindByIdCategoryUseCaseImp(categoryGateway);
    }

    @Bean
    public UpdateCategoryUseCase updateCategory (CategoryGateway categoryGateway){
        return new UpdateCategoryUseCaseImp(categoryGateway);
    }

    @Bean
    DeleteCategoryUseCase deleteCategory (CategoryGateway categoryGateway){
        return new DeleteCategoryUseCaseImp(categoryGateway);
    }

}
