package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.MgoProductDto;
import com.cludus.clugest.services.MgoProductService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("mongodb")
@RestController
@RequestMapping(path = "/mongo/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class MgoProductController {
    @Autowired
    private MgoProductService service;

    @GetMapping("/find-all")
    public List<MgoProductDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/search/{name}")
    public List<MgoProductDto> findByName(@PathVariable String name) {
        return service.searchProductsByName(name);
    }

    @PostMapping
    public void create(@RequestBody MgoProductDto product) {
        service.create(product);
    }
}
