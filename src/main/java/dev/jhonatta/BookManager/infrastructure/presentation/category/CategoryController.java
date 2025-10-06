package dev.jhonatta.BookManager.infrastructure.presentation.category;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.usercase.category.create.CreateCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.delete.DeleteCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.findById.FindByIdCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.findAll.FindCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.update.UpdateCategoryUseCase;
import dev.jhonatta.BookManager.infrastructure.dtos.category.CategoryDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bookmanager/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindCategoryUseCase findCategoryUseCase;
    private final FindByIdCategoryUseCase findByIdCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final CategoryMapper categoryMapper;



    @PostMapping("/createcategory")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.toDto(createCategoryUseCase.execute(categoryMapper.toEntity(categoryDTO))));
    }

    @GetMapping("/listallcategory")
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(findCategoryUseCase.execute().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList()));
    }


    @GetMapping("/listbyid/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryMapper.toDto(findByIdCategoryUseCase.execute(id)));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryMapper.toDto(updateCategoryUseCase.execute(id,categoryMapper.toEntity(categoryDTO))));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        deleteCategoryUseCase.execute(id);
       return ResponseEntity.noContent().build();
    }

}
