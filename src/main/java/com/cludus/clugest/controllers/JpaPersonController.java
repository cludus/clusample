package com.cludus.clugest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Profile("jpa")
@RestController("/jpa")
public class JpaPersonController {



    @GetMapping("/read")
    public void read() {
        log.error("JPA reading");
    }

    @PostMapping("/write")
    public void write() {
        log.error("JPA writing");
    }
}
