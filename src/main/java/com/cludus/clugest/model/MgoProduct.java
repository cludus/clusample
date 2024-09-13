package com.cludus.clugest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.neo4j.core.schema.Id;

@Document(collection = "clugest_products")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MgoProduct {
    @Id
    private String id;

    private String name;
}
