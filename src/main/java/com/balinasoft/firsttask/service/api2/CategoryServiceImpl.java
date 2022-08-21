package com.balinasoft.firsttask.service.api2;

import com.balinasoft.firsttask.domain.Image;
import com.balinasoft.firsttask.domain.api2.Category;
import com.balinasoft.firsttask.dto.ImageDtoOut;
import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import com.balinasoft.firsttask.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryDTOOut save(CategoryDTOIn categoryDTOIn) {
        Category category = new Category();
        category.setLocalDateTime(LocalDateTime.now());
        category.setName(categoryDTOIn.getName());
        categoryRepository.save(category);
        return this.toDto(category);
    }


    public Page<CategoryDTOOut> findAll(int page) {
        PageRequest pageRequest = new PageRequest(page, 20, new Sort("id"));
        Page<Category> categories = categoryRepository.findAll(pageRequest);
        return categories.map(this::toDto);
    }

    @Override
    public CategoryDTOOut findByName(String name) {
        Category category;
        try {
            category = categoryRepository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
            // Категория не найдена
        }
        return this.toDto(category);
    }

    @Override
    public void delete(String name) {
        Category category;
        try {
            category = categoryRepository.findByName(name);
            categoryRepository.delete(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
            // Категория не найдена
        }
    }

    private CategoryDTOOut toDto(Category category) {
        return new CategoryDTOOut(category.getId(),
                category.getName(),
                category.getLocalDateTime(),
                category.getImages());
    }
}
