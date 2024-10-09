package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.RedisAuthCodeReq;
import com.cludus.clugest.dtos.RedisAuthCodeResp;
import com.cludus.clugest.services.RedisAuthCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("redis")
@RestController
@RequestMapping(path = "/redis/auth-code", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisAuthCodeController {
    @Autowired
    private RedisAuthCodeService service;

    @GetMapping("/find-all")
    public void findAll() {
        log.error("JPA reading");
    }

    @PostMapping
    public RedisAuthCodeResp create(@RequestBody RedisAuthCodeReq entity) {
        return service.createCode(entity);
    }
}
