package com.balinasoft.firsttask.repository.category;

import com.balinasoft.firsttask.domain.api2.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category>findByName(String name);
    Optional<Category>findById(int id);
}
