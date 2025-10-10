package dev.jhonatta.BookManager.infrastructure.presentation.author;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.usercase.author.create.CreateAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.delete.DeleteAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.findall.FindAllAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.findbyid.FindByIdAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.update.UpdateAuthorUseCase;
import dev.jhonatta.BookManager.infrastructure.dtos.author.AuthorDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.author.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bookmanager/author")
@RequiredArgsConstructor
public class AuthorController {

    private final CreateAuthorUseCase createAuthorUseCase;
    private final FindAllAuthorUseCase findAllAuthorUseCase;
    private final FindByIdAuthorUseCase findByIdAuthorUseCase;
    private final UpdateAuthorUseCase updateAuthorUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;
    private final AuthorMapper authorMapper;

    @PostMapping("/createauthor")
    public ResponseEntity<AuthorDTO> createAuthor (@RequestBody AuthorDTO authorDTO){
        Author newAuthor = createAuthorUseCase.execute(authorMapper.toEntity(authorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(authorMapper.toDto(newAuthor));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<AuthorDTO>> findAll (){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(findAllAuthorUseCase.execute().stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/findid/{id}")
    public ResponseEntity<AuthorDTO> findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(authorMapper.toDto(findByIdAuthorUseCase.execute(id)));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable Long id, @RequestBody AuthorDTO authorDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authorMapper.toDto(updateAuthorUseCase.execute(id, authorMapper.toEntity(authorDTO))));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id){
        deleteAuthorUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
