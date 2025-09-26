package dev.jhonatta.BookManager.infrastructure.presentation;

import dev.jhonatta.BookManager.core.entities.Category;
import dev.jhonatta.BookManager.core.usercase.category.CreateCategoryUseCase;
import dev.jhonatta.BookManager.core.usercase.category.FindCategoryUseCase;
import dev.jhonatta.BookManager.infrastructure.dtos.CategoryDTO;
import dev.jhonatta.BookManager.infrastructure.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bookmanager/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindCategoryUseCase findCategoryUseCase;
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

}
