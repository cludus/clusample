package com.cludus.clugest.repositories;

import com.cludus.clugest.model.MgoProduct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("mongodb")
public interface MgoProductRepository extends MongoRepository<MgoProduct, String> {
}
