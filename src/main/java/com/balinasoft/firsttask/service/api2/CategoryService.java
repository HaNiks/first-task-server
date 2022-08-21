package com.balinasoft.firsttask.service.api2;

import com.balinasoft.firsttask.dto.api2.CategoryDTOIn;
import com.balinasoft.firsttask.dto.api2.CategoryDTOOut;

public interface CategoryService {
    CategoryDTOOut save(CategoryDTOIn categoryDTOIn);

    CategoryDTOOut findByName(String name);

    void delete(String name);
}
