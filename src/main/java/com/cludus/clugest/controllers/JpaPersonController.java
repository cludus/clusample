package com.cludus.clugest.controllers;

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

    @GetMapping("/find-all")
    public void findAll() {
        log.error("JPA reading");
    }

    @PostMapping
    public JpaPersonResp create(@RequestBody JpaPersonReq person) {
        return service.create(person);
    }
}
