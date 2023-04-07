package com.example.productserviceassignment.serives;

import com.example.productserviceassignment.models.Product;

import java.util.List;

public interface ProductService {
    //interface should be as general as possible.
    Product getProductById(Long id);

    List<Product> getAllProducts();
}
