package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.KfkPlayEventReq;
import com.cludus.clugest.dtos.KfkPlayEventResp;
import com.cludus.clugest.model.KfkPlayEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("kafka")
@Service
public class KfkPlayEventMapper {
    public KfkPlayEventResp toResp(KfkPlayEvent model) {
        return KfkPlayEventResp.builder()
                .id(model.getId())
                .build();
    }

    public KfkPlayEvent toModel(KfkPlayEventReq req) {
        return KfkPlayEvent.builder()
                .id(req.getId())
                .build();
    }
}
