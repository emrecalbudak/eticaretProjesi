package com.spring.project.dataAccess.abstracts;

import com.spring.project.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category getByCategoryName(String categoryName);

}
