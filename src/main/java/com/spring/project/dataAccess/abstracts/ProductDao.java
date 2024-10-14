package com.spring.project.dataAccess.abstracts;

import com.spring.project.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName); // getBy : WHERE komutu döndürüyor. WHERE productName = "..." şeklinde.
    Product getByProductNameAndCategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

    
}
