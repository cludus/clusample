package com.cludus.clugest.controllers;

import com.cludus.clugest.dtos.KfkPlayEventReq;
import com.cludus.clugest.dtos.KfkPlayEventResp;
import com.cludus.clugest.services.KfkPlayEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Profile("kafka")
@RestController
@RequestMapping(path = "/kafka/play-event", produces = MediaType.APPLICATION_JSON_VALUE)
public class KfkPlayEventController {
    @Autowired
    private KfkPlayEventService service;

    @PostMapping
    public KfkPlayEventResp addPlayEvent(@RequestBody KfkPlayEventReq playEvent) {
        return service.addPlayEvent(playEvent);
    }

    @GetMapping
    public List<KfkPlayEventResp> poolPlayEvent() {
        return service.getPlayEvents();
    }
}
