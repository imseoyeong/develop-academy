package com.example.test_store_backend.controller;

import com.example.test_store_backend.data.entity.Product;
import com.example.test_store_backend.data.dto.ProductDTO;
import com.example.test_store_backend.data.repository.ProductRepository;
import com.example.test_store_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = this.productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductDTO);
    }

    // 상품 수정
    @PutMapping(value = "/product")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO updateProductDTO = this.productService.updateProductById(productDTO);
        if (updateProductDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updateProductDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 상품 삭제
    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        boolean result = this.productService.deleteProductById(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("상품 삭제 성공");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제 상품 검색 실패");
    }
}
