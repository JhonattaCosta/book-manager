package dev.jhonatta.BookManager.infrastructure.presentation.book;

import dev.jhonatta.BookManager.core.entities.Book;
import dev.jhonatta.BookManager.core.usercase.book.create.CreateBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.delete.DeleteBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findall.FindAllBookUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findbyauthorname.FindByBooksByAuthorNameUseCase;
import dev.jhonatta.BookManager.core.usercase.book.findyname.FindByNameUseCase;
import dev.jhonatta.BookManager.core.usercase.book.update.UpdateBookUseCase;
import dev.jhonatta.BookManager.infrastructure.dtos.book.BookDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.book.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final BookMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<BookDTO> createBook (@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(createBookUseCase.execute(mapper.toEntity(bookDTO))));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<BookDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(findAllBookUseCase.execute().stream().map(mapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/findname/{name}")
    public ResponseEntity<List<BookDTO>> findByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.FOUND).body(findByNameUseCase.execute(name).stream().map(mapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/findauthor/{author}")
    public ResponseEntity<List<BookDTO>> findByAuthor(@PathVariable String author){
        return ResponseEntity.status(HttpStatus.FOUND).body(findByAuthorNameUseCase.execute(author).stream().map(mapper::toDto).collect(Collectors.toList()));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@RequestBody BookDTO bookDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.toDto(updateBookUseCase.execute(id, mapper.toEntity(bookDTO))));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        deleteBookUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }



}
