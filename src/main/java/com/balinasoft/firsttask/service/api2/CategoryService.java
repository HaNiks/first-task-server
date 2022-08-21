package com.balinasoft.firsttask.service.api2;

import com.balinasoft.firsttask.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
}
