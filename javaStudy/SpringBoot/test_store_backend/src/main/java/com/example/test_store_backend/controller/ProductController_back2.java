//package com.example.test_store_backend.controller;
//
//import com.example.test_store_backend.data.entity.Product;
//import com.example.test_store_backend.data.dto.ProductDTO;
//import com.example.test_store_backend.data.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//public class ProductController {
//    private final ProductRepository productRepository;
//
//    // 상품 정보를 모두 가져오기
//    @GetMapping(value = "/product-list")
//    public ResponseEntity<List<ProductDTO>> getProductList() {
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        List<Product> productList = this.productRepository.findAll();
//        for (Product product : productList) {
//            ProductDTO productDTO = ProductDTO.builder()
//                    .id(product.getId())
//                    .price(product.getPrice())
//                    .title((product.getTitle()))
//                    .imagesrc(product.getImagesrc())
//                    .build();
//            productDTOList.add(productDTO);
//        }
//        return ResponseEntity.ok(productDTOList);
//    }
//
//    // 상품 등록
//    @PostMapping(value = "/new-product")
//    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
//        Product product = Product.builder()
//                .price(productDTO.getPrice())
//                .title(productDTO.getTitle())
//                .imagesrc("https://dummyimage.com/200x200/00f/fff.jpg&text=product")
//                .build();
//
//        Product saveProduct = this.productRepository.save(product);
//
//        ProductDTO savedProductDTO = ProductDTO.builder()
//                .id(saveProduct.getId())
//                .price(saveProduct.getPrice())
//                .title(saveProduct.getTitle())
//                .imagesrc(saveProduct.getImagesrc())
//                .build();
//
//        return ResponseEntity.ok(savedProductDTO);
//    }
//
//    // 상품 수정
//    @PutMapping(value = "/product")
//    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
//        // 뭔 옵셔널 프로덕트를 가져온다는데 뭔 소린지 몰겠쌈
//        Optional<Product> productOp = this.productRepository.findById(productDTO.getId());
//        if (productOp.isPresent()) {
//            Product product = productOp.get();
//            product.setPrice(productDTO.getPrice()); // 가격만 수정하면 되니깐 얘만
//            Product updateProduct = this.productRepository.save(product); // 그리고 저장
//
//            ProductDTO updateProductDTO = ProductDTO.builder()
//                    .id(updateProduct.getId())
//                    .price(updateProduct.getPrice())
//                    .title(updateProduct.getTitle())
//                    .imagesrc(updateProduct.getImagesrc())
//                    .build();
//
//            return ResponseEntity.status(HttpStatus.OK).body(updateProductDTO);
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//
//    // 상품 삭제
//    @DeleteMapping(value = "/product/{id}")
//    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
//        if (this.productRepository.existsById(id)) {
//            this.productRepository.deleteById(id);
//            return ResponseEntity.status(HttpStatus.OK).body("상품 삭제 성공");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }
//}
