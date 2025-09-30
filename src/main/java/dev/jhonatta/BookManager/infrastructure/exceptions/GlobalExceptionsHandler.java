package dev.jhonatta.BookManager.infrastructure.exceptions;

import dev.jhonatta.BookManager.core.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFound(CategoryNotFoundException ex){
        Map<String, String> response = new HashMap<>();
        response.put("Error ", ex.getMessage());
        response.put("Message: ", "Please, insert a valid Id fr your category and try again");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
