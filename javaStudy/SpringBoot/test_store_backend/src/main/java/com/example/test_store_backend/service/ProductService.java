package com.example.test_store_backend.service;

import com.example.test_store_backend.data.dao.ProductDAO;
import com.example.test_store_backend.data.dto.ProductDTO;
import com.example.test_store_backend.data.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDAO productDAO;

    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> products = this.productDAO.getAllProducts();
        for (Product product : products) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .imagesrc(product.getImagesrc())
                    .title(product.getTitle())
                    .price(product.getPrice())
                    .build();
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    public ProductDTO getProductById(Integer id) {
        Product product = this.productDAO.getProductById(id);
        if (product != null) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .imagesrc(product.getImagesrc())
                    .title(product.getTitle())
                    .price(product.getPrice())
                    .build();
            return productDTO;
        }
        return null;
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = this.productDAO.saveProduct(productDTO.getTitle(),
                "https://dummyimage.com/200x200/00f/fff.jpg&text=product", productDTO.getPrice());
        ProductDTO saveproductDTO = ProductDTO.builder()
                .id(product.getId())
                .imagesrc(product.getImagesrc())
                .title(product.getTitle())
                .price(product.getPrice())
                .build();
        return saveproductDTO;
    }

    public ProductDTO updateProductById(ProductDTO productDTO) {
        Product product = this.productDAO.updateProductById(productDTO.getId(),
                productDTO.getPrice());
        if (product != null) {
            ProductDTO updateproductDTO = ProductDTO.builder()
                    .id(product.getId())
                    .imagesrc(product.getImagesrc())
                    .title(product.getTitle())
                    .price(product.getPrice())
                    .build();
            return updateproductDTO;
        }
        return null;
    }

    public boolean deleteProductById(Integer id) {
        return this.productDAO.deleteProductById(id);
    }



}
