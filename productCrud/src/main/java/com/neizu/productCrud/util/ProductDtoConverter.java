package com.neizu.productCrud.util;

import com.neizu.productCrud.dto.ProductDto;
import com.neizu.productCrud.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConverter {

    public ProductDto converter(Product product){
        ProductDto productDto=ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
        return productDto;
    }






}
