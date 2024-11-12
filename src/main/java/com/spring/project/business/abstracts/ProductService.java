package com.spring.project.business.abstracts;

import com.spring.project.core.utilities.results.DataResult;
import com.spring.project.core.utilities.results.Result;
import com.spring.project.entities.concretes.*;
import com.spring.project.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    Result add(Product product);

    DataResult<Product> getByProductName(String productName); // getBy : WHERE komutu döndürüyor. WHERE productName = "..." şeklinde.
    DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>>  getByProductNameContains(String productName); //içeriyor ise
    DataResult<List<Product>>  getByProductNameStartsWith(String productName); //başlıyor ise
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();


}
