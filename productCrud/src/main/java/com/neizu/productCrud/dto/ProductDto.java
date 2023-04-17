package com.neizu.productCrud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private String name;

    private Double price;

}
