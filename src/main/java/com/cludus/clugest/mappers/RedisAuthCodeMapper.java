package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.RedisAuthCodeReq;
import com.cludus.clugest.dtos.RedisAuthCodeResp;
import com.cludus.clugest.model.RedisAuthCode;
import org.springframework.stereotype.Service;

@Service
public class RedisAuthCodeMapper {
    public RedisAuthCodeResp toResp(RedisAuthCode model) {
        return RedisAuthCodeResp.builder()
                .id(model.getId())
                .code(model.getCode())
                .userId(model.getUserId())
                .build();
    }

    public RedisAuthCode toModel(RedisAuthCodeReq req) {
        return RedisAuthCode.builder()
                .code(req.getCode())
                .userId(req.getUserId())
                .build();
    }
}
