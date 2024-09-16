package com.springboot.test.repository;

import com.springboot.test.data.entity.Product;
import com.springboot.test.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ProductRepositoryTest2 {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void basicCRUDTest(){
        /*create*/
        //given
        Product givenProduct = Product.builder()
                .name("펜")
                .price(1000)
                .stock(500)
                .build();


        //when
        Product savedProduct = productRepository.save(givenProduct);

        //then
        Assertions.assertEquals(givenProduct.getName(), savedProduct.getName());
        Assertions.assertEquals(givenProduct.getPrice(), savedProduct.getPrice());
        Assertions.assertEquals(givenProduct.getStock(), savedProduct.getStock());

        /*read*/
        //when
        Product selectedProduct = productRepository.findById(savedProduct.getNumber()).orElseThrow(RuntimeException::new);

        //then
        Assertions.assertEquals(givenProduct.getNumber(), selectedProduct.getNumber());
        Assertions.assertEquals(givenProduct.getName(), selectedProduct.getName());
        Assertions.assertEquals(givenProduct.getPrice(), selectedProduct.getPrice());
        Assertions.assertEquals(givenProduct.getStock(), selectedProduct.getStock());

        /*update*/
        //when
        Product foundProduct = productRepository.findById(selectedProduct.getNumber()).orElseThrow(RuntimeException::new);

        foundProduct.setName("장난감");

        Product updatedProduct = productRepository.save(foundProduct);

        //then
        Assertions.assertEquals(updatedProduct.getName(), "장난감");


        /*delete*/
        //when
        productRepository.delete(updatedProduct);

        //then
        Assertions.assertFalse(productRepository.findById(selectedProduct.getNumber()).isPresent());
    }

}
