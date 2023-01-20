package com.rubic.productquery.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.rubic.productquery.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final ElasticsearchClient elasticsearchClient;
    private static final String INDEX_NAME = "products";
//    private static final String CREATED_STATUS = "Created";

    public String createOrUpdate(Product product) throws IOException {
        IndexResponse indexResponse = elasticsearchClient.index(p ->
                p.index(INDEX_NAME)
                        .id(product.getId())
                        .document(product));
        return indexResponse.result().name();
    }

    public Product findById(String id) throws IOException {
        GetResponse<Product> response = elasticsearchClient.get(p -> p.index(INDEX_NAME).id(id), Product.class);
        if (response.found()) return response.source();
        //TODO: throw an exception if it is not found
        return null;
    }
}
