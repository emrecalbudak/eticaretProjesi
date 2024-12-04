package com.spring.project.api.controllers;

import com.spring.project.business.abstracts.CategoryService;
import com.spring.project.core.utilities.results.DataResult;
import com.spring.project.core.utilities.results.Result;
import com.spring.project.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoriesController {
    private CategoryService categoryService;
    @Autowired
    public CategoriesController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }
    @GetMapping("/getall")
    public DataResult<List<Category>> getAllCategories() {
        return this.categoryService.getAll();
    }
    @PostMapping("/add")
    public Result addCategory(@RequestBody Category category) {
        return this.categoryService.add(category);
    }
}
