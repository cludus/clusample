package com.cludus.clugest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("clugest_chat_messages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CassChatMessage {
    @PrimaryKey
    private String id;

    private String content;
}
