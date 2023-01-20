package com.rubic.productquery.controller;

import com.rubic.productquery.controller.mapper.ProductMapper;
import com.rubic.productquery.controller.model.request.CreateProductRequest;
import com.rubic.productquery.controller.model.response.ProductResponse;
import com.rubic.productquery.controller.model.response.StatusModelResponse;
import com.rubic.productquery.model.Product;
import com.rubic.productquery.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(ProductController.PRODUCT_CONTROLLER_ADDRESS)
@RequiredArgsConstructor
public class ProductController {
    public static final String PRODUCT_CONTROLLER_ADDRESS = "/products";

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatusModelResponse create(@RequestBody CreateProductRequest createProductRequest) throws IOException {
        Product product = productMapper.createProductRequestModelToProduct(createProductRequest);
        String status = productRepository.createOrUpdate(product);
        return new StatusModelResponse(status);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse findById(@PathVariable("id") String id) throws IOException {
        Product product = productRepository.findById(id);
        return productMapper.productToProductResponse(product);
    }

}
