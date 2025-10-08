package dev.jhonatta.BookManager.infrastructure.gateway;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.entities.Category;
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


@Component
@RequiredArgsConstructor
public class BookRepositoryGateway implements BookGateway {

    private final BookRepository repository;
    private final BookEntityMapper mapper;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Book createBook(Book book) {
        BookEntity entity = mapper.toEntity(book);
        BookEntity entitySave = repository.save(entity);
        return mapper.toDomain(entitySave);
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
        if (bookOpt.isPresent()){
            BookEntity bookEntity = bookOpt.get();
           if(book.name() != null){
               bookEntity.setName(book.name());
           }
           if(book.description() != null){
               bookEntity.setDescription(book.description());
           }
           if(book.releaseDay() != null){
               bookEntity.setReleaseDay(book.releaseDay());
           }
           if(book.identifier() != null){
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
       return null;
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existByName(String name) {
        return repository.findAll().stream()
                .anyMatch(book -> book.getName().equalsIgnoreCase(name));
    }
}
