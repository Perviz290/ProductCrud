package com.neizu.productCrud.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductRequest {

    private String name;

    private Double price;




}
