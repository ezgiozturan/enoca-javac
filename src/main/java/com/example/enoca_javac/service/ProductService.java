package com.example.enoca_javac.service;

import com.example.enoca_javac.dto.ProductDTO;
import com.example.enoca_javac.entity.Product;
import com.example.enoca_javac.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        return productRepository.save(product);
    };

    public Product updateProduct(long productId, ProductDTO productDTO){
        Product product = productRepository.findById(productId);
         //Exception eklenecek
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(product);


    };

    public void deleteProduct(long productId){
        productRepository.deleteById(productId);
    };

    public Optional<Product> getProduct(long productId){
        return productRepository.findById(productId);
    };
}
