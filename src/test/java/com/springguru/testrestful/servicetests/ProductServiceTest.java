package com.springguru.testrestful.servicetests;

import com.springguru.testrestful.exceptions.ProductAlreadyExistsException;
import com.springguru.testrestful.models.Product;
import com.springguru.testrestful.repositories.ProductRepository;
import com.springguru.testrestful.services.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

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

    @AfterEach
    public void tearDown() {
        product1 = product2 = null;
        productList = null;
    }

    @Test
    public void givenGetAllUsersShouldReturnListOfAllUsers() {
        productRepository.save(product1);
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> productList1 = productService.getAllProducts();
        assertEquals(productList1, productList);
        verify(productRepository,times(1)).save(product1);
        verify(productRepository,times(1)).findAll();
    }

    @Test
    public void givenProductToAddShouldReturnAddedProduct() throws ProductAlreadyExistsException {
        when(productRepository.save(any())).thenReturn(product1);
        productService.addProduct(product1);
        verify(productRepository, times(1)).save(any());
    }

    @Test
    public void givenIdShouldReturnProductOfThatId() {
        Mockito.when(productRepository.findById(1)).thenReturn(Optional.ofNullable(product1));
        assertThat(productService.getProductById(product1.getProductId())).isEqualTo(product1);
    }

/*    @Test
    public void givenIdToDeleteThenShouldDeleteTheProduct() {
        Optional optional;
        Mockito.when(productService.deleteProductById(product1.getProductId())).thenReturn(product1);
        verify(productRepository, times(1)).findAll();
    }*/
}
