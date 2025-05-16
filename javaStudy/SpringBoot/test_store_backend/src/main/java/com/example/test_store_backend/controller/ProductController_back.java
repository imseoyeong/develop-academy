//package com.example.test_store_backend.controller;
//
//import com.example.test_store_backend.data.entity.Product;
//import com.example.test_store_backend.data.dto.ProductDTO;
//import com.example.test_store_backend.data.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequiredArgsConstructor
//public class ProductController_back {
//    private final ProductRepository productRepository;
//
//    // 상품 정보를 모두 가져오기
//    @GetMapping(value = "/product-list")
//    public List<ProductDTO> getProductList() {
//        List<ProductDTO> productDTOList = new ArrayList<>();
//        List<Product> productList = this.productRepository.findAll();
//        for (Product product : productList) {
//            ProductDTO productDTO = ProductDTO.builder()
//                    .id(product.getId())
//                    .price(product.getPrice())
//                            .title((product.getTitle()))
//            productDTOList.add(productDTO);
//        }
//    }
//
//    // 상품 등록
//    @PostMapping(value = "/new-product")
//    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
//        Product product = new Product();
//        product.setPrice(productDTO.getPrice());
//        product.setTitle(productDTO.getTitle());
//        product.setImagesrc("https://dummyimage.com/200x200/00f/fff.jpg&text=product");
//        Product saveProduct = this.productRepository.save(product);
////        return saveProduct; // Product가 아니고 ProductDTO에 다시 담아서 리턴해야 함.
//        ProductDTO savedProductDTO = new ProductDTO();
//        savedProductDTO.setTitle(saveProduct.getTitle());
//        savedProductDTO.setPrice(saveProduct.getPrice());
//        savedProductDTO.setImagesrc(saveProduct.getImagesrc());
//        savedProductDTO.setId(saveProduct.getId());
//        return savedProductDTO;
//    }
//
//    // 상품 수정
//    @PutMapping(value = "/product")
//    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
//        // 뭔 옵셔널 프로덕트를 가져온다는데 뭔 소린지 몰겠쌈
//        Optional<Product> productOp = this.productRepository.findById(productDTO.getId());
//        if (productOp.isPresent()) {
//            Product product = productOp.get();
//            product.setPrice(productDTO.getPrice()); // 가격만 수정하면 되니깐 얘만
//            Product updateProduct = this.productRepository.save(product); // 그리고 저장
//            ProductDTO updateProductDTO = new ProductDTO(); // 하지만 DTO에 다시 담아서 리턴해야 함
//            updateProductDTO.setTitle(updateProduct.getTitle());
//            updateProductDTO.setPrice(updateProduct.getPrice());
//            updateProductDTO.setImagesrc(updateProduct.getImagesrc());
//            updateProductDTO.setId(updateProduct.getId());
//            return updateProductDTO;
//        }
//        return null;
//    }
//
//    // 상품 삭제
//    @DeleteMapping(value = "/product/{id}")
//    public String deleteProduct(@PathVariable Integer id) {
//        if (this.productRepository.existsById(id)) {
//            this.productRepository.deleteById(id);
//            return "Product deleted successfully";
//        }
//        return "Product not found";
//    }
//}
