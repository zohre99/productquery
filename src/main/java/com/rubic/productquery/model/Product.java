package com.rubic.productquery.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "products")
@Data
public class Product {

    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "code", norms = false)
    private String code;

    @Field(type = FieldType.Text, name = "name", docValues = false)
    private String name;

    @Field(type = FieldType.Keyword, name = "name", docValues = false)
    private String color;

    @Field(type = FieldType.Text, name = "description", docValues = false)
    private String description;

    @Field(type = FieldType.Integer, name = "stock", norms = false)
    private Integer stock;

    @Field(type = FieldType.Date, name = "created_date", index = false)
    private Date createdDate;

    @Field(type = FieldType.Date, name = "last_modified_date", index = false)
    private Date lastModifiedDate;

}
