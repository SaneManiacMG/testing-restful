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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Rubber Duck", 50);
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

    @Test
    public void givenGetAllProductShouldReturnListOfAllProduct() {
        Product product1 = new Product(2, "Bat", 250);
        Product product2 = new Product(3, "Ball", 20);
        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList = (List<Product>) productRepository.findAll();
        assertEquals("Ball", productList.get(1).getProductName());
    }

    @Test
    public void givenGetIdThenShouldReturnProductOfThatId() {
        Product product1 = new Product(2, "Bat", 250);
        Product product2 = productRepository.save(product1);

        Optional<Product> productOptional = productRepository.findById(product2.getProductId());
        assertEquals(product2.getProductId(), productOptional.get().getProductId());
        assertEquals(product2.getProductName(), productOptional.get().getProductName());
    }

    @Test
    public void givenIdToDeleteThenShouldDeleteTheProduct() {
        Product product4 = new Product(1, "Pen", 110);
        productRepository.save(product4);
        productRepository.deleteById(product4.getProductId());
        Optional optional = productRepository.findById(product.getProductId());
        assertEquals(Optional.empty(), optional);
    }
}
