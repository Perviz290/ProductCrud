package com.neizu.productCrud.dto.response;

import com.neizu.productCrud.dto.ProductDto;
import com.neizu.productCrud.entity.Product;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductResponse {


    public List<ProductDto> producList;




}
