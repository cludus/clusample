package com.cludus.clugest.repositories;

import com.cludus.clugest.model.MgoProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Profile("mongodb")
public interface MgoProductRepository extends MongoRepository<MgoProduct, String> {
    @Query(value = "{name:/?0/}", fields = "{'name' : 1, 'description' : 1}")
    List<MgoProduct> searchProductsByName(String name);
}
