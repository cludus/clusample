package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.*;
import com.cludus.clugest.services.N4jEconomicEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("neo4j")
@RestController
@RequestMapping(path = "/neo4j/economic-entity", produces = MediaType.APPLICATION_JSON_VALUE)
public class N4jEconomicEntityController {
    @Autowired
    private N4jEconomicEntityService service;

    @GetMapping("/{id}")
    public N4jEconomicEntityResp find(@PathVariable("id") Long id) {
        return service.find(id);
    }

    @PostMapping
    public N4jEconomicEntityResp create(@RequestBody N4jEconomicEntityReq person) {
        return service.create(person);
    }

    @PostMapping("/{id}")
    public N4jEconomicEntityResp update(@PathVariable("id") Long id, @RequestBody N4jEconomicEntityReq person) {
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public AcknowledgedResp delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
