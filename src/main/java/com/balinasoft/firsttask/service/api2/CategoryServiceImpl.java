package com.balinasoft.firsttask.service.api2;

import com.balinasoft.firsttask.domain.api2.Category;
import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import com.balinasoft.firsttask.repository.ImageRepository;
import com.balinasoft.firsttask.repository.category.CategoryRepository;
import com.balinasoft.firsttask.system.error.exception.category.CategoryNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Value("${page.size}")
    private int size;
    @Value("${sort.key}")
    private String sort;

    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;
    private final ObjectMapper objectMapper;


    @Override
    public CategoryDTOOut save(CategoryDTOIn categoryDTOIn) {
        String categoryName = categoryDTOIn.getName().toLowerCase(Locale.ROOT);
        Category category = new Category();
        category.setDate(new Date());
        category.setName(categoryName);
        categoryRepository.save(category);
        return this.toDto(category);
    }


    public Page<CategoryDTOOut> findAll(int page) {
        PageRequest pageRequest = new PageRequest(page, size, new Sort(sort));
        Page<Category> categories = categoryRepository.findAll(pageRequest);
        return categories.map(this::toDto);
    }

    @Override
    public CategoryDTOOut findById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        return this.toDto(category);
    }

    @Override
    public void delete(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        imageRepository.delete(id);
        categoryRepository.delete(category);
    }

    private CategoryDTOOut toDto(Category category) {
        return objectMapper.convertValue(category, CategoryDTOOut.class);
    }
}
