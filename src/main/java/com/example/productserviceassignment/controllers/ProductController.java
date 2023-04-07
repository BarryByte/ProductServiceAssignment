package com.example.productserviceassignment.controllers;

import com.example.productserviceassignment.dtos.ExceptionDto;
import com.example.productserviceassignment.dtos.FakeStoreProductDto;
import com.example.productserviceassignment.models.Product;
import com.example.productserviceassignment.serives.FakeStoreProductService;
import com.example.productserviceassignment.serives.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
* Controller should be as light as possible.
* there should be no business logic in the controller.
* the controller should only be responsible for handling the request and sending the response.
* the controller should delegate the business logic to the service layer.
*
* that's why we should use constroller advice to handle exceptions.
* it is the final thing through which the request passes before reaching to the client.
* so it is the best place to handle exceptions.
*
* in the controller advice we can modify the response and send it to the client.
* controllerAdivce is also a Annotation based approach to handle exceptions.
* within controller advice class we can define methods with @ControllerAdvice annotation.
* which can modify the response and send it to the client.
* */
@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    //




    // an example showcasing exception handling in spring boot.
    // the method getProductById() is supposed to return a product with a given id.
    // if the product is not found, the method throws a RuntimeException.
    // when the exception is caught an ExceptionDto object is created and returned.
    // the ExceptionDto object contains a message and a resolution.
    // return type is ResponseEntity, not ResponseEntity<Product> or ResponseEntity<ExceptionDto>.
    // the return type is ResponseEntity so that the return type can be ResponseEntity<Product> or ResponseEntity<ExceptionDto>.
    // depending on the try and catch block in the method
    @GetMapping("{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id){
        ResponseEntity<Product> responseEntity = null;
        Product product = null ;
        try {

            System.out.println("Hellooooooooo");
            product = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);

        } catch(RuntimeException exception) {

            ExceptionDto dto = new ExceptionDto();
            dto.setMessage("Something went wrong !");
            dto.setResolution(" Do nothing, Eat 5 star !");

            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
            return response;
        }
        return responseEntity;
    }

    @GetMapping("")
    public List<Product> getAllProducts(){
        return  productService.getAllProducts();
    }

}
