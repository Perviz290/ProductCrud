package com.neizu.productCrud.controller;

import com.neizu.productCrud.dto.ProductDto;
import com.neizu.productCrud.dto.request.CreateProductRequest;
import com.neizu.productCrud.dto.request.UpdateProductRequest;
import com.neizu.productCrud.dto.response.ProductResponse;
import com.neizu.productCrud.entity.Product;
import com.neizu.productCrud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductRequest createProductRequest){
       productService.createProduct(createProductRequest);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto findByProductId(@PathVariable Integer id){
        return productService.findByProductId(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByProductId(@PathVariable Integer id){
        productService.deleteByProductId(id);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Product updateProduct (@PathVariable Integer id, @RequestBody UpdateProductRequest updateProductRequest){
        return productService.updateProduct(id,updateProductRequest);
    }













}
