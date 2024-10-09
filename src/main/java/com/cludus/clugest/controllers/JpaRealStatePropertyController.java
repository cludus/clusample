package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.*;
import com.cludus.clugest.services.JpaRealStatePropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("jpa")
@RestController
@RequestMapping(path = "/jpa/real-state-property", produces = MediaType.APPLICATION_JSON_VALUE)
public class JpaRealStatePropertyController {

    @Autowired
    private JpaRealStatePropertyService service;

    @GetMapping("/{id}")
    public JpaRealStatePropertyResp find(@PathVariable("id") Long id) {
        return service.find(id);
    }

    @PostMapping
    public JpaRealStatePropertyResp create(@RequestBody JpaRealStatePropertyReq rsProperty) {
        return service.create(rsProperty);
    }

    @PostMapping("/{id}")
    public JpaRealStatePropertyResp update(@PathVariable("id") Long id, @RequestBody JpaRealStatePropertyReq rsProperty) {
        return service.update(id, rsProperty);
    }

    @DeleteMapping("/{id}")
    public AcknowledgedResp delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
