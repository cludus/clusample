package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.CassChatMessageReq;
import com.cludus.clugest.dtos.EsPostReq;
import com.cludus.clugest.dtos.EsPostResp;
import com.cludus.clugest.services.EsPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Profile("elasticsearch")
@RestController
@RequestMapping(path = "/elasticsearch/post", produces = MediaType.APPLICATION_JSON_VALUE)
public class EsPostController {
    @Autowired
    private EsPostService service;

    @GetMapping("/find-all")
    public void findAll() {
        log.error("JPA reading");
    }

    @PostMapping
    public EsPostResp create(@RequestBody EsPostReq post) {
        return service.createPost(post);
    }
}
