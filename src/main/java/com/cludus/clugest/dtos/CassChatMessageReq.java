package com.cludus.clugest.dtos;

import com.cludus.clugest.model.CassChatMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CassChatMessageReq {
    private String id;

    private String senderId;

    private String senderSessionId;

    private String senderRegion;

    private String senderAz;

    private String receiverId;

    private String content;

    private long timestamp;
}
