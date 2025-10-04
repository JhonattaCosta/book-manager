package dev.jhonatta.BookManager.infrastructure.presentation.author;

import dev.jhonatta.BookManager.core.entities.Author;
import dev.jhonatta.BookManager.core.usercase.author.create.CreateAuthorUseCase;
import dev.jhonatta.BookManager.core.usercase.author.findall.FindAllAuthorUseCase;
import dev.jhonatta.BookManager.infrastructure.dtos.author.AuthorDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.author.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bookmanager/author")
@RequiredArgsConstructor
public class AuthorController {

    private final CreateAuthorUseCase createAuthorUseCase;
    private final FindAllAuthorUseCase findAllAuthorUseCase;
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

}
