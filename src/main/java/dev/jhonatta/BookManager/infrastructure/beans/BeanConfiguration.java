package dev.jhonatta.BookManager.infrastructure.beans;

import dev.jhonatta.BookManager.core.gateway.CategoryGateway;
import dev.jhonatta.BookManager.core.usercase.category.CreateCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.CreateCategoryUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.category.FindCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.FindCategoryUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateCategoryUseCase createCategory (CategoryGateway categoryGateway){
        return new CreateCategoryUseCaseImp(categoryGateway);
    }

    @Bean
    public FindCategoryUseCase FindAllCategory (CategoryGateway categoryGateway){
        return new FindCategoryUseCaseImp(categoryGateway);
    }

}
