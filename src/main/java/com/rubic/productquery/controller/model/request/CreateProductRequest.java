package com.rubic.productquery.controller.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateProductRequest {
    private String id;
    private String code;
    private String color;
    private String name;
    private String description;
    private Integer stock;
    private Date createdDate;
    private Date lastModifiedDate;
}
