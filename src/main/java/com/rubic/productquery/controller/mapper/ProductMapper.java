package com.rubic.productquery.controller.mapper;

import com.rubic.productquery.controller.model.request.CreateProductRequest;
import com.rubic.productquery.controller.model.response.ProductResponse;
import com.rubic.productquery.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product createProductRequestModelToProduct(CreateProductRequest createProductRequest);

    ProductResponse productToProductResponse(Product product);

}
