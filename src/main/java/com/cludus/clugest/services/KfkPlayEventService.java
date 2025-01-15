package com.cludus.clugest.services;

import com.cludus.clugest.dtos.KfkPlayEventReq;
import com.cludus.clugest.dtos.KfkPlayEventResp;
import com.cludus.clugest.mappers.KfkPlayEventMapper;
import com.cludus.clugest.repositories.KfkPlayEventProducer;
import com.cludus.clugest.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("kafka")
public class KfkPlayEventService {
    @Autowired
    private KfkPlayEventProducer producer;

    @Autowired
    private KfkPlayEventMapper mapper;

    public KfkPlayEventResp addPlayEvent(KfkPlayEventReq playEvent) {
        var model = mapper.toModel(playEvent);
        producer.sendMessage(model);
        return mapper.toResp(model);
    }

    public List<KfkPlayEventResp> getPlayEvents() {
        return null;
    }

    @KafkaListener(id = "myId", topics = "play_event")
    public void listen(String in) {
        System.out.println(in);
    }
}
