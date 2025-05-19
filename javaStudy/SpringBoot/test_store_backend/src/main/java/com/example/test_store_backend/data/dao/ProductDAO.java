package com.example.test_store_backend.data.dao;

import com.example.test_store_backend.data.entity.Product;
import com.example.test_store_backend.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.orElse(null);
    }

    public Product saveProduct(String title, String imagesrc, Integer price, LocalDateTime created, String description) {
        Product product = Product.builder()
                .title(title)
                .imagesrc(imagesrc)
                .price(price)
                .created(created)
                .description(description)
                .build();
        return this.productRepository.save(product);
    }

    public boolean deleteProductById(Integer id) {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Product updateProductById(Integer id, Integer price, LocalDateTime updated, String description) {
        Optional<Product> product = this.productRepository.findById(id);
        Product updatedProduct = product.orElse(null);
        if (updatedProduct != null) {
            updatedProduct.setPrice(price);
            updatedProduct.setDescription(description);
            updatedProduct.setCreated(updated);
            return this.productRepository.save(updatedProduct);
        }
        return null;
    }
}
