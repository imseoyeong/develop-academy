package com.example.test_store_backend2.controller;

import com.example.test_store_backend2.data.Product;
import com.example.test_store_backend2.data.ProductDTO;
import com.example.test_store_backend2.data.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping(value = "/product-list")
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @PostMapping(value = "/new-product")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImagesrc("https://dummyimage.com/200x200/00f/fff.jpg&text=product");
        Product saveProduct = this.productRepository.save(product);
        ProductDTO savedProductDTO = new ProductDTO();
        savedProductDTO.setTitle(saveProduct.getTitle());
        savedProductDTO.setId(saveProduct.getId());
        savedProductDTO.setPrice(saveProduct.getPrice());
        savedProductDTO.setImagesrc(saveProduct.getImagesrc());
        return savedProductDTO;
    }

    @PutMapping(value = "/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        Optional<Product> productOp = this.productRepository.findById(productDTO.getId());
        if (productOp.isPresent()) {
            Product product = productOp.get();
            product.setPrice(productDTO.getPrice());
            Product updateProduct = this.productRepository.save(product);
            ProductDTO updateProductDTO = new ProductDTO();
            updateProductDTO.setId(updateProduct.getId());
            updateProductDTO.setTitle(updateProduct.getTitle());
            updateProductDTO.setPrice(updateProduct.getPrice());
            updateProductDTO.setImagesrc(updateProduct.getImagesrc());
            return updateProductDTO;
        }
        return null;
    }

    @DeleteMapping(value = "/product/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
            return "Product deleted successfully";
        }
        return "Product not found";
    }
}
