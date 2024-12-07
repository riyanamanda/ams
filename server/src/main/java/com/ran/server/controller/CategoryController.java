package com.ran.server.controller;

import com.ran.server.entity.Category;
import com.ran.server.request.CategoryCreateRequest;
import com.ran.server.request.CategoryUpdateRequest;
import com.ran.server.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Riyan Amanda
 * {@code @linkedin} <a href="https://linkedin.com/in/riyan-amanda">...</a>
 * @since 06/12/2024, Friday
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> create(@Valid @RequestBody CategoryCreateRequest request) {
        categoryService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body("Category created");
    }

    @GetMapping(
        path = "{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping(
        path = "{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> update(@Valid @PathVariable("id") Integer id, @RequestBody CategoryUpdateRequest request) {
        categoryService.update(id, request);

        return ResponseEntity.ok("Category updated");
    }

    @DeleteMapping(
        path = "{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);

        return ResponseEntity.ok("Category deleted");
    }
}
