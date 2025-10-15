package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.exceptions.EntityNotFoundException;
import dev.jhonatta.BookManager.core.gateway.BookGateway;
import dev.jhonatta.BookManager.infrastructure.mappers.book.BookEntityMapper;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.author.AuthorRepository;
import dev.jhonatta.BookManager.infrastructure.persistence.book.BookEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.book.BookRepository;
import dev.jhonatta.BookManager.infrastructure.persistence.category.CategoryEntity;
import dev.jhonatta.BookManager.infrastructure.persistence.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.concurrent.ThreadLocalRandom;


@Component
@RequiredArgsConstructor
public class BookRepositoryGateway implements BookGateway {

    private final BookRepository repository;
    private final BookEntityMapper mapper;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    private final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int numberLetters = 3;
    private final int numberNumbers = 3;

    @Override
    public Book createBook(Book book) {
        BookEntity entity = mapper.toEntity(book);
        String identifier;
        do {
            identifier = createRandomIdentifier();
        }while (existByIdentifier(identifier) == true);
        entity.setIdentifier(identifier);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public String createRandomIdentifier() {
        ThreadLocalRandom randomizer = ThreadLocalRandom.current();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < numberLetters; i++){
            int indice = randomizer.nextInt(letters.length());
            stringBuilder.append(letters.charAt(indice));
        }
        stringBuilder.append("-");

       for(int i = 0; i < numberNumbers; i++){
           int generatorNumber = randomizer.nextInt(10);
           stringBuilder.append(generatorNumber);
       }
        return stringBuilder.toString();
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorName(String auhtor) {
        return repository.findBooksByAuthorNameContaining(auhtor).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Book updateBook(Long id, Book book){
        Optional<BookEntity> bookOpt = repository.findById(id);
        BookEntity findBook = bookOpt.orElseThrow(()->
                new EntityNotFoundException(
                        "Livro com id: " + id + " Não foi encontrado!"
                ));
        if (bookOpt.isPresent()){
            BookEntity bookEntity = bookOpt.get();
           if(book.name() != null && !book.name().isBlank()){
               bookEntity.setName(book.name());
           }
           if(book.description() != null && !book.description().isBlank()){
               bookEntity.setDescription(book.description());
           }
           if(book.releaseDay() != null){
               bookEntity.setReleaseDay(book.releaseDay());
           }
           if(book.identifier() != null && !book.identifier().isBlank()){
               bookEntity.setIdentifier(book.identifier());
           }
           if (book.categories() != null && !book.categories().isEmpty()){
               List<Long> categoryIds = book.categories().stream()
                        .map(category -> category.id())
                        .collect(Collectors.toList());
               List<CategoryEntity> categoryEntities = categoryRepository.findAllById(categoryIds);
                    if (categoryEntities.size() != categoryIds.size()){
                        throw  new RuntimeException("Uma ou mais categorias não foram encontradas");
                    }
            bookEntity.setCategories(categoryEntities);
           }
           if(book.author() != null && !book.author().isEmpty()){
               List<Long> authorIds = book.author().stream()
                       .map(author -> author.id())
                       .collect(Collectors.toList());
               List<AuthorEntity> authorEntities = authorRepository.findAllById(authorIds);
                    if (authorEntities.size() != authorIds.size()){
                        throw new RuntimeException("Um ou mais Autores não foram encontrados");
                    }
           bookEntity.setAuthor(authorEntities);
           }
           BookEntity updatedBook = repository.save(bookEntity);
            return mapper.toDomain(updatedBook);
        }
       return mapper.toDomain(findBook);
    }

    @Override
    public boolean existByIdentifier(String indentifier) {
        return repository.findAll().stream()
                .anyMatch(book -> book.getIdentifier().equalsIgnoreCase(indentifier));
    }

    @Override
    public void deleteBook(Long id) {
        BookEntity findBook = repository.findById(id).orElseThrow(()->
                new EntityNotFoundException(
                        "Livro com id: " + id + " Não foi encontrado!"
                )
            );
        repository.delete(findBook);
    }
}
