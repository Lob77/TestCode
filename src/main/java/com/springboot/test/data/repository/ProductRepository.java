package com.springboot.test.data.repository;

import com.springboot.test.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// 예제 6.7
public interface ProductRepository extends JpaRepository<Product, Long> {

}
