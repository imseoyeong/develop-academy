package com.example.test_store_backend.controller;

import com.example.test_store_backend.data.entity.Product;
import com.example.test_store_backend.data.dto.ProductDTO;
import com.example.test_store_backend.data.repository.ProductRepository;
import com.example.test_store_backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // 상품 정보를 모두 가져오기
    @GetMapping(value = "/product-list")
    public ResponseEntity<List<ProductDTO>> getProductList() {
        List<ProductDTO> productDTOList = this.productService.getAllProducts();
        return ResponseEntity.ok(productDTOList);
    }

    // 상품 등록
    @PostMapping(value = "/new-product")
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = this.productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductDTO);
    }

    // 상품 수정
    @PutMapping(value = "/product")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO updateProductDTO = this.productService.updateProductById(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateProductDTO);
    }

    // 상품 삭제
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        this.productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body("상품 삭제 성공");
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductDTO> getException(@PathVariable Integer id) {
        ProductDTO productDTO = this.productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }
}
