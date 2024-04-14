package com.example.productserviceassignment.serives;

import com.example.productserviceassignment.dtos.FakeStoreProductDto;
import com.example.productserviceassignment.models.Product;
import com.sun.security.jgss.AuthorizationDataEntry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService  implements ProductService{
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public Product getProductById(Long id){
        //call the fakestore api to get the product with given id ;

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        //convert fakestoredto object into Product object;
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());

        return product;
    }
}
