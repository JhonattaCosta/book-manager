package dev.jhonatta.BookManager.infrastructure.beans;

import dev.jhonatta.BookManager.core.gateway.AuthorGateway;
import dev.jhonatta.BookManager.core.usercase.author.create.CreateAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.create.CreateAuthorUseCaseImp;
import dev.jhonatta.BookManager.core.usercase.author.findall.FindAllAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.findall.FindAllAuthorUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorBeanConfiguration {

    @Bean
    public CreateAuthorUseCase createAuthor (AuthorGateway authorGateway){
        return new CreateAuthorUseCaseImp(authorGateway);
    }

    @Bean
    public FindAllAuthorUseCase findAll (AuthorGateway authorGateway){
        return  new FindAllAuthorUseCaseImp(authorGateway);
    }
}
