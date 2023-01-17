package com.springguru.testrestful.repositorytests;

import com.springguru.testrestful.models.Product;
import com.springguru.testrestful.repositories.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Rubber Duck", 5);
    }

    @AfterEach
    public void tearDown() {
        productRepository.deleteAll();
        product = null;
    }

    @Test
    public void givenProductToAddShouldReturnAddedProduct() {
        productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getProductId()).get();
        assertEquals(1, fetchedProduct.getProductId());
    }
}
