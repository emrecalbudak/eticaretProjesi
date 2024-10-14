package com.spring.project.business.abstracts;

import com.spring.project.core.utilities.results.DataResult;
import com.spring.project.core.utilities.results.Result;
import com.spring.project.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
