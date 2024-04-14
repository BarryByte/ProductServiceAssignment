package com.example.productserviceassignment.serives;

import com.example.productserviceassignment.models.Product;

public interface ProductService {
    //interface should be as general as possible.
    Product getProductById(Long id);
}
