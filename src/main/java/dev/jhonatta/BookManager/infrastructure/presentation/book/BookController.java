package dev.jhonatta.BookManager.infrastructure.presentation.book;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findall.FindAllBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findbyauthorname.FindByBooksByAuthorNameUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findyname.FindByNameUseCase;
import dev.jhonatta.BookManager.infrastructure.dtos.book.BookDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.book.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bookmanager/book")
@RequiredArgsConstructor
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final FindAllBookUseCase findAllBookUseCase;
    private final FindByNameUseCase findByNameUseCase;
    private final FindByBooksByAuthorNameUseCase findByAuthorNameUseCase;
    private final BookMapper mapper;

    @PostMapping("/create")
    public BookDTO createBook (@RequestBody BookDTO bookDTO){
        Book newBook = createBookUseCase.execute(mapper.toEntity(bookDTO));
        return mapper.toDto(newBook);
    }

    @GetMapping("/findall")
    public List<BookDTO> findAll(){
        return findAllBookUseCase.execute().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/findname/{name}")
    public List<BookDTO> findByName(@PathVariable String name){
        return findByNameUseCase.execute(name).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/findauthor/{author}")
    public List<BookDTO> findByAuthor(@PathVariable String author){
        return findByAuthorNameUseCase.execute(author).stream().map(mapper::toDto).collect(Collectors.toList());
    }



}
