package com.balinasoft.firsttask.service.api2;

import com.balinasoft.firsttask.domain.api2.Category;
import com.balinasoft.firsttask.dto.ImageDtoIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import com.balinasoft.firsttask.repository.category.CategoryRepository;
import com.balinasoft.firsttask.service.ImageService;
import com.balinasoft.firsttask.system.error.exception.category.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ImageService imageService;


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
        PageRequest pageRequest = new PageRequest(page, 20, new Sort("id"));
        Page<Category> categories = categoryRepository.findAll(pageRequest);
        return categories.map(this::toDto);
    }

    @Override
    public CategoryDTOOut findByName(String name) {
        Category category;
        try {
            category = categoryRepository.findByName(name.toLowerCase(Locale.ROOT));
        } catch (Exception e) {
            throw new CategoryNotFoundException();
        }
        return this.toDto(category);
    }

    @Override
    public void delete(String name) {
        Category category;
        try {
            category = categoryRepository.findByName(name);
            List<ImageDtoIn> inList = imageService.findAllByCategoryName(name);
            inList.forEach(imageService::uploadImage);
            categoryRepository.delete(category);
        } catch (Exception e) {
            throw new CategoryNotFoundException();
        }
    }

    private CategoryDTOOut toDto(Category category) {
        return new CategoryDTOOut(category.getId(),
                category.getName(),
                category.getDate(),
                category.getImages()
        );
    }
}
