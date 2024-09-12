package com.cludus.clugest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("clugest_auth_code")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedisAuthCode {
    @Id
    private String id;
    private String code;
    private String userId;
}
