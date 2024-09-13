package com.cludus.clugest.services;

import com.cludus.clugest.repositories.N4jEconomicEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("neo4j")
public class N4jEconomicEntityService {
    @Autowired
    private N4jEconomicEntityRepository repo;
}
