package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.CassChatMessageReq;
import com.cludus.clugest.dtos.CassChatMessageResp;
import com.cludus.clugest.model.CassChatMessage;
import org.springframework.stereotype.Service;

@Service
public class CassChatMessageMapper {
    public CassChatMessageResp toResp(CassChatMessage model) {
        return CassChatMessageResp.builder()
                .id(model.getId())
                .senderId(model.getSenderId())
                .senderSessionId(model.getSenderSessionId())
                .senderRegion(model.getSenderRegion())
                .senderAz(model.getSenderAz())
                .receiverId(model.getReceiverId())
                .content(model.getContent())
                .timestamp(model.getTimestamp())
                .build();
    }

    public CassChatMessage toModel(CassChatMessageReq req) {
        return CassChatMessage.builder()
                .content(req.getContent())
                .id(req.getId())
                .receiverId(req.getReceiverId())
                .senderAz(req.getSenderAz())
                .senderId(req.getSenderId())
                .senderRegion(req.getSenderRegion())
                .senderSessionId(req.getSenderSessionId())
                .timestamp(req.getTimestamp())
                .build();
    }
}
