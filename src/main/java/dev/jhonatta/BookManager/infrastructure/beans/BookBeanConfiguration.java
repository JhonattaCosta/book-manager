package dev.jhonatta.BookManager.infrastructure.beans;

import dev.jhonatta.BookManager.core.gateway.AuthorGateway;
import dev.jhonatta.BookManager.core.gateway.BookGateway;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookBeanConfiguration {

    @Bean
    public CreateBookUseCase create(BookGateway bookGateway){
        return new CreateBookUseCaseImp(bookGateway);
    }
}
