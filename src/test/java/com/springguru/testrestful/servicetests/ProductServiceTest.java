package com.springguru.testrestful.servicetests;

import com.springguru.testrestful.models.Product;
import com.springguru.testrestful.repositories.ProductRepository;
import com.springguru.testrestful.services.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Autowired
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;
    List<Product> productList;

    @BeforeEach
    public void setUp() {
        productList = new ArrayList<>();
        product1 = new Product(1, "bread", 20);
        product2 = new Product(2, "Jam", 200);
    }
}
