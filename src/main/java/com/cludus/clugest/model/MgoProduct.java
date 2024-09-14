package com.cludus.clugest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "clugest_products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MgoProduct {
    @MongoId
    private String id;

    @Indexed
    private String name;

    private String description;
}
