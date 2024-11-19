package com.cludus.clugest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KfkPlayEvent {
    private String id;

    private String userId;

    private String songId;

    private int songTime;

    private long timestamp;

    private String type;
}
