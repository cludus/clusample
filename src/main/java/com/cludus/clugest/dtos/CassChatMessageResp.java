package com.cludus.clugest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CassChatMessageResp {
    private String id;

    private String senderId;

    private String senderSessionId;

    private String senderRegion;

    private String senderAz;

    private String receiverId;

    private String content;

    private long timestamp;
}
