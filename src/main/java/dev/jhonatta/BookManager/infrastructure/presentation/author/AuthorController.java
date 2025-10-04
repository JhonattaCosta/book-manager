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
    public AuthorDTO createAuthor (@RequestBody AuthorDTO authorDTO){
        Author newAuthor = createAuthorUseCase.execute(authorMapper.toEntity(authorDTO));
        return authorMapper.toDto(newAuthor);
    }

    @GetMapping("/findall")
    public List<AuthorDTO> findAll (){
        return findAllAuthorUseCase.execute().stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/findid/{id}")
    public Optional<AuthorDTO> findById (@PathVariable Long id){
        Author author = findByIdAuthorUseCase.execute(id);
        return Optional.of(authorMapper.toDto(author));
    }

    @PatchMapping("/update/{id}")
    public Optional<AuthorDTO> update(@PathVariable Long id, @RequestBody AuthorDTO authorDTO){
        Author author = updateAuthorUseCase.execute(id, authorMapper.toEntity(authorDTO));
        AuthorDTO updatedAuthor = authorMapper.toDto(author);
        return Optional.of(updatedAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById (@PathVariable Long id){
        deleteAuthorUseCase.execute(id);
    }
}
