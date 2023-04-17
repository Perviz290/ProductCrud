package com.neizu.productCrud.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProductRequest {

    private String name;
    private Double price;


}
