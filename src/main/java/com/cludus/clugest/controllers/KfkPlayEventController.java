package com.cludus.clugest.controllers;

import com.cludus.clugest.services.KfkPlayEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Profile("kafka")
@RestController
@RequestMapping(path = "/kafka/play-event", produces = MediaType.APPLICATION_JSON_VALUE)
public class KfkPlayEventController {
    @Autowired
    private KfkPlayEventService service;

    @GetMapping("/find-all")
    public void findAll() {
        log.error("JPA reading");
    }

    @PostMapping
    public void create() {
        log.error("JPA writing");
    }
}
