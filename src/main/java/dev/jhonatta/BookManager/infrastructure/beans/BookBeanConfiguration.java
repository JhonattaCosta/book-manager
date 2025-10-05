package dev.jhonatta.BookManager.infrastructure.beans;

import dev.jhonatta.BookManager.core.gateway.BookGateway;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.book.findall.FindAllBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findall.FindAllBookUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.book.findbyauthorname.FindByBooksByAuthorNameUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findbyauthorname.FindByBooksByAuthorNameUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.book.findyname.FindByNameUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findyname.FindByNameUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.book.update.UpdateBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.update.UpdateBookUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;

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

    @Bean
    public FindByBooksByAuthorNameUseCase findByAuthorName(BookGateway bookGateway){
        return new FindByBooksByAuthorNameUseCaseImp(bookGateway);
    }

    @Bean
    public UpdateBookUseCase updateBoo(BookGateway bookGateway){
        return new UpdateBookUseCaseImp(bookGateway);
    }
}
