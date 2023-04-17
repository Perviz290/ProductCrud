package com.neizu.productCrud.service.interfaces;

import com.neizu.productCrud.dto.ProductDto;
import com.neizu.productCrud.dto.request.CreateProductRequest;
import com.neizu.productCrud.dto.request.UpdateProductRequest;
import com.neizu.productCrud.dto.response.ProductResponse;
import com.neizu.productCrud.entity.Product;

import java.util.List;

public interface ProductInterface {



    public void createProduct(CreateProductRequest createProductRequest);

    public ProductResponse getAllProduct();

    public ProductDto findByProductId(Integer id);

    public void deleteByProductId(Integer id);

    public Product
    updateProduct(Integer id,UpdateProductRequest updateProductRequest);








}
