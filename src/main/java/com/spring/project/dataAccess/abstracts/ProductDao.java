package com.spring.project.dataAccess.abstracts;

import com.spring.project.entities.concretes.*;
import com.spring.project.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName); // getBy : WHERE komutu döndürüyor. WHERE productName = "..." şeklinde.
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int category);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName); //içeriyor ise
    List<Product> getByProductNameStartsWith(String productName); //başlıyor ise

    @Query("From Product where productName=:productName and category.categoryId=:categoryId") //veritabanı tablosundan bağımsız, entity isimleri ve değişkenleri ile query yazılır.
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("Select new com.spring.project.entities.dtos.ProductWithCategoryDto" +
            "(p.id, p.productName, c.categoryName) " +
            "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

    @Query("From Product where category.categoryId=:categoryId")
    List<Product> findByCategoryId(int categoryId);
    //select p.productId,p.productName, c.categoryName from
    // Category c inner join Product p on c.categoryId = p.categoryId
}
