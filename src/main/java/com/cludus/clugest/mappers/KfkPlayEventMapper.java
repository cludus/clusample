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
                .userId(model.getUserId())
                .songId(model.getSongId())
                .songTime(model.getSongTime())
                .timestamp(model.getTimestamp())
                .type(model.getType())
                .build();
    }

    public KfkPlayEvent toModel(KfkPlayEventReq req) {
        return KfkPlayEvent.builder()
                .id(req.getId())
                .songId(req.getSongId())
                .songTime(req.getSongTime())
                .timestamp(req.getTimestamp())
                .userId(req.getUserId())
                .type(req.getType())
                .build();
    }
}
