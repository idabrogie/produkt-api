package com.example.produktapi.repository;

import com.example.produktapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    Optional<Product> findByTitle(String title);

    @Query("SELECT distinct category FROM Product")
    List<String> findAllCategories();
}
