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
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
        Category newCategory = createCategoryUseCase.execute(categoryMapper.toEntity(categoryDTO));
        return categoryMapper.toDto(newCategory);
    }

    @GetMapping("/listallcategory")
    public List<CategoryDTO> findAll(){
        return findCategoryUseCase.execute().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/listbyid/{id}")
    public Optional<CategoryDTO> findById(@PathVariable Long id){
        Category findCategory = findByIdCategoryUseCase.execute(id);
        CategoryDTO findCategoryDto = categoryMapper.toDto(findCategory);
        return Optional.of(findCategoryDto);
    }

    @PatchMapping("/update/{id}")
    public Optional<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        Category foundCategory = updateCategoryUseCase.execute(id,categoryMapper.toEntity(categoryDTO));
        CategoryDTO updatedCategory = categoryMapper.toDto(foundCategory);
        return Optional.of(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        deleteCategoryUseCase.execute(id);
    }

}
