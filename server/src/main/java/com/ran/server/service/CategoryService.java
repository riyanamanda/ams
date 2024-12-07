package com.ran.server.service;

import com.ran.server.entity.Category;
import com.ran.server.request.CategoryCreateRequest;
import com.ran.server.request.CategoryUpdateRequest;

import java.util.List;

/**
 * @author Riyan Amanda
 * {@code @linkedin} <a href="https://linkedin.com/in/riyan-amanda">...</a>
 * @since 06/12/2024, Friday
 **/

public interface CategoryService {
    public List<Category> findAll();

    void create(CategoryCreateRequest request);

    Category findById(Integer id);

    void update(Integer id, CategoryUpdateRequest request);

    void delete(Integer id);
}
