package com.cludus.clugest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Profile("jpa")
@RestController
@RequestMapping(path = "/jpa/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class JpaPersonController {


    @GetMapping("/find-all")
    public void findAll() {
        log.error("JPA reading");
    }

    @PostMapping
    public void create() {
        log.error("JPA writing");
    }
}
