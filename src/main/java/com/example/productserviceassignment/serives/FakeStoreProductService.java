package com.example.productserviceassignment.serives;

import com.example.productserviceassignment.dtos.FakeStoreProductDto;
import com.example.productserviceassignment.models.Category;
import com.example.productserviceassignment.models.Product;
import com.sun.security.jgss.AuthorizationDataEntry;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService  implements ProductService{
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com/products/";
    @Override
    public Product getProductById(Long id){
        //call the fakestore api to get the product with given id ;

        throw new RuntimeException(" Something went damn wrogn in service");
       /* FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject( url+ id, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            return null;
        }
        //convert fakestoredto object into Product object;
        return convertFakeStoreProductDtotoProduct(fakeStoreProductDto);*/
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
       // List<FakeStoreProductDto> fakeStoreProductDtos =
               // restTemplate.getForObject(url, List<FakeStoreProductDto>.class);
        // generics practice :
       // List<FakeStoreProductDto> fakeStoreProductDtos =
                //restTemplate.getForObject(url, List.class);
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject(url, FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtotoProduct(fakeStoreProductDto));
        }
        return products;

    }

    private Product convertFakeStoreProductDtotoProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getTitle());
        product.setCategory(category);
        category.setDescription(fakeStoreProductDto.getDescription());



        return product;
    }
}
