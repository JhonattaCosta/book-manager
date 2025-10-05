package dev.jhonatta.BookManager.infrastructure.beans;

import dev.jhonatta.BookManager.core.gateway.AuthorGateway;
import dev.jhonatta.BookManager.core.gateway.BookGateway;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.book.findall.FindAllBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findall.FindAllBookUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.book.findyname.FindByNameUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findyname.FindByNameUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookBeanConfiguration {

    @Bean
    public CreateBookUseCase createBook(BookGateway bookGateway){
        return new CreateBookUseCaseImp(bookGateway);
    }

    @Bean
    public FindAllBookUseCase findAllBook(BookGateway bookGateway){
        return new FindAllBookUseCaseImp(bookGateway);
    }

    @Bean
    public FindByNameUseCase findByNameBook(BookGateway bookGateway){
        return new FindByNameUseCaseImp(bookGateway);
    }
}
