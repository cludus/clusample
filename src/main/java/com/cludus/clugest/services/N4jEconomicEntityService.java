package com.cludus.clugest.services;

import com.cludus.clugest.dtos.*;
import com.cludus.clugest.mappers.KfkPlayEventMapper;
import com.cludus.clugest.mappers.Neo4jEconomicEntityMapper;
import com.cludus.clugest.repositories.N4jEconomicEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@Profile("neo4j")
public class N4jEconomicEntityService {
    @Autowired
    private N4jEconomicEntityRepository repo;

    @Autowired
    private Neo4jEconomicEntityMapper mapper;

    @GetMapping("/{id}")
    public N4jEconomicEntityResp find(Long id) {
        return null;
    }

    public N4jEconomicEntityResp create(N4jEconomicEntityReq entity) {
        return null;
    }

    public N4jEconomicEntityResp update(Long id, N4jEconomicEntityReq entity) {
        return null;
    }

    public AcknowledgedResp delete(Long id) {
        return null;
    }
}
