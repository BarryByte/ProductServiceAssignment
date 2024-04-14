package com.example.productserviceassignment.controllers;

import com.example.productserviceassignment.dtos.FakeStoreProductDto;
import com.example.productserviceassignment.models.Product;
import com.example.productserviceassignment.serives.FakeStoreProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private FakeStoreProductService fakeStoreProductService;
    ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }

    //

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return fakeStoreProductService.getProductById(id);
    }

}
