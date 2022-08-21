package com.balinasoft.firsttask.repository.category;

import com.balinasoft.firsttask.domain.api2.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
