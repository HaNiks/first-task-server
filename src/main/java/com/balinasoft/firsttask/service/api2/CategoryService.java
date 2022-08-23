package com.balinasoft.firsttask.service.api2;

import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;
import org.springframework.data.domain.Page;

public interface CategoryService {
    CategoryDTOOut save(CategoryDTOIn categoryDTOIn);

    CategoryDTOOut findById(int id);

    void delete(int id);

    Page<CategoryDTOOut> findAll(int page);
}
