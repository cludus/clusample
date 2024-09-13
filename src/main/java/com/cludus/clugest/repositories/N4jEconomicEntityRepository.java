package com.cludus.clugest.repositories;

import com.cludus.clugest.model.N4jEconomicEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

@Profile("neo4j")
public interface N4jEconomicEntityRepository extends Neo4jRepository<N4jEconomicEntity, Long> {
    N4jEconomicEntity findByName(String name);
}
