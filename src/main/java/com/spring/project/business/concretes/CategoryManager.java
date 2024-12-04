package com.spring.project.business.concretes;

import com.spring.project.business.abstracts.CategoryService;
import com.spring.project.core.utilities.results.DataResult;
import com.spring.project.core.utilities.results.Result;
import com.spring.project.core.utilities.results.SuccessDataResult;
import com.spring.project.core.utilities.results.SuccessResult;
import com.spring.project.dataAccess.abstracts.CategoryDao;
import com.spring.project.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        super();
        this.categoryDao = categoryDao;
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return new SuccessDataResult<List<Category>>
                (this.categoryDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Category category) {
        this.categoryDao.save(category);
        return new SuccessResult("Ürün Eklendi");
    }
}
