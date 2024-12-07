package com.ran.server.service.impl;

import com.ran.server.entity.Category;
import com.ran.server.repository.CategoryRepository;
import com.ran.server.request.CategoryCreateRequest;
import com.ran.server.request.CategoryUpdateRequest;
import com.ran.server.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Riyan Amanda
 * {@code @linkedin}  <a href="https://linkedin.com/in/riyan-amanda">...</a>
 * @since 06/12/2024, Friday
 **/

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void create(CategoryCreateRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new RuntimeException("Category name already exist");
        }

        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void update(Integer id, CategoryUpdateRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new RuntimeException("Category name already exist");
        }

        Category category = categoryRepository.findById(id).get();
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new RuntimeException("Category not found");
        }

        categoryRepository.deleteById(id);
    }
}
