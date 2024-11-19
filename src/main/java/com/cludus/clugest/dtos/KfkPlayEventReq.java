package com.cludus.clugest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KfkPlayEventReq {
    private String id;

    private String userId;

    private String songId;

    private int songTime;

    private long timestamp;

    private String type;
}
