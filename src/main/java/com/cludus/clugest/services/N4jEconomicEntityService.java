package com.cludus.clugest.services;

import com.cludus.clugest.dtos.*;
import com.cludus.clugest.mappers.Neo4jEconomicEntityMapper;
import com.cludus.clugest.repositories.N4jEconomicEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("neo4j")
public class N4jEconomicEntityService {
    @Autowired
    private N4jEconomicEntityRepository repo;

    @Autowired
    private Neo4jEconomicEntityMapper mapper;

    @GetMapping("/{id}")
    public N4jEconomicEntityResp find(Long id) {
        return repo.findById(id)
                .map(mapper::toResp)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "economic entity not found"));
    }

    public N4jEconomicEntityResp create(N4jEconomicEntityReq req) {
        var model = mapper.toModel(req);
        repo.save(model);
        return mapper.toResp(model);
    }

    public N4jEconomicEntityResp update(Long id, N4jEconomicEntityReq req) {
        var model = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "economic entity not found"));
        model.setName(req.getName());
        repo.save(model);
        return mapper.toResp(model);
    }

    public AcknowledgedResp delete(Long id) {
        repo.deleteById(id);
        return AcknowledgedResp.builder()
                .acknowledged(true)
                .build();
    }
}
