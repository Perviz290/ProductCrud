package com.neizu.productCrud.service;

import com.neizu.productCrud.dto.ProductDto;
import com.neizu.productCrud.dto.request.CreateProductRequest;
import com.neizu.productCrud.dto.request.UpdateProductRequest;
import com.neizu.productCrud.dto.response.ProductResponse;
import com.neizu.productCrud.entity.Product;
import com.neizu.productCrud.exception.IdNotFoundException;
import com.neizu.productCrud.repository.ProductRepo;
import com.neizu.productCrud.service.interfaces.ProductInterface;
import com.neizu.productCrud.util.ProductDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductInterface {

    private final ProductRepo productRepo;
    private final ProductDtoConverter productDtoConverter;


    @Override
    public void createProduct(CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .build();
        productRepo.save(product);
    }

    @Override
    public ProductResponse getAllProduct() {
        List<ProductDto> productDtoList = productRepo.findAll()
                .stream()
                .map(productDtoConverter::converter)
                .collect(Collectors.toList());
        return ProductResponse.builder()
                .producList(productDtoList)
                .build();
    }

    @Override
    public ProductDto findByProductId(Integer id) {
        return productRepo.findById(id).map(productDtoConverter::converter)
                .orElseThrow(() -> new IdNotFoundException(id + "-id is not found"));
    }

    @Override
    public void deleteByProductId(Integer id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            productRepo.deleteById(id);
        } else {
            throw new IdNotFoundException(id + "-id is not found");
        }
    }


    @Override
    public Product updateProduct(Integer id, UpdateProductRequest updateProductRequest) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product = Product.builder()
                    .id(id)
                    .name(updateProductRequest.getName())
                    .price(updateProductRequest.getPrice())
                    .build();
            productRepo.save(product);
            return product;
        } else {
            throw new IdNotFoundException(id + "-id is not found");
        }
    }
}


















