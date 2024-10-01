package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.CassChatMessageReq;
import com.cludus.clugest.dtos.CassChatMessageResp;
import com.cludus.clugest.services.CassChatMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("cassandra")
@RestController
@RequestMapping(path = "/cassandra/chat-message", produces = MediaType.APPLICATION_JSON_VALUE)
public class CassChatMessageController {

    @Autowired
    private CassChatMessageService service;

    @GetMapping("/find-all")
    public void findAll() {
        log.error("cassandra reading");
    }

    @PostMapping
    public CassChatMessageResp addMessage(@RequestBody CassChatMessageReq message) {
        return service.add(message);
    }

}
