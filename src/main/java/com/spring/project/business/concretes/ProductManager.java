package com.spring.project.business.concretes;

import com.spring.project.business.abstracts.ProductService;
import com.spring.project.core.utilities.results.DataResult;
import com.spring.project.core.utilities.results.Result;
import com.spring.project.core.utilities.results.SuccessDataResult;
import com.spring.project.core.utilities.results.SuccessResult;
import com.spring.project.dataAccess.abstracts.ProductDao;
import com.spring.project.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün Eklendi");
    }
}
