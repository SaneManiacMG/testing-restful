package com.springguru.testrestful.services;

import com.springguru.testrestful.exceptions.ProductAlreadyExistsException;
import com.springguru.testrestful.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product addProduct(Product product) throws ProductAlreadyExistsException;
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product deleteProductById(int id);
}
