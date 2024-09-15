package com.springboot.test.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jayway.jsonpath.internal.function.sequence.First;
import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.data.entity.Product;
import com.springboot.test.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ProductServiceTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUpTest(){
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void saveProductTest(){

        Mockito.when(
                productRepository.save(any(Product.class))).then(AdditionalAnswers.returnsFirstArg());

        ProductResponseDto productResponseDto = productService.saveProduct(new ProductDto("펜",1000,1234));

        Assertions.assertSame(productResponseDto.getName(),"펜");
        Assertions.assertEquals(productResponseDto.getPrice(), 1000);
        Assertions.assertEquals(productResponseDto.getStock(), 1234);

        verify(productRepository).save(any());
    }
}
