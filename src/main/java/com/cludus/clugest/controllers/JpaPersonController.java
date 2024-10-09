package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.AcknowledgedResp;
import com.cludus.clugest.dtos.JpaPersonReq;
import com.cludus.clugest.dtos.JpaPersonResp;
import com.cludus.clugest.services.JpaPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("jpa")
@RestController
@RequestMapping(path = "/jpa/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class JpaPersonController {

    @Autowired
    private JpaPersonService service;

    @GetMapping("/{id}")
    public JpaPersonResp find(@PathVariable("id") Long id) {
        return service.find(id);
    }

    @PostMapping
    public JpaPersonResp create(@RequestBody JpaPersonReq person) {
        return service.create(person);
    }

    @PostMapping("/{id}")
    public JpaPersonResp update(@PathVariable("id") Long id, @RequestBody JpaPersonReq person) {
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public AcknowledgedResp delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
