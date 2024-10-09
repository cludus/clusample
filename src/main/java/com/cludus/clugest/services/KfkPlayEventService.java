package com.cludus.clugest.services;

import com.cludus.clugest.dtos.KfkPlayEventReq;
import com.cludus.clugest.dtos.KfkPlayEventResp;
import com.cludus.clugest.repositories.KfkPlayEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("kafka")
public class KfkPlayEventService {
    @Autowired
    private KfkPlayEventProducer producer;

    public KfkPlayEventResp addPlayEvent(KfkPlayEventReq playEvent) {
        return null;
    }
}
