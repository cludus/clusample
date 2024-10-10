package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.JpaPersonReq;
import com.cludus.clugest.dtos.JpaPersonResp;
import com.cludus.clugest.model.JpaPerson;
import org.springframework.stereotype.Service;

@Service
public class JpaPersonMapper {
    public JpaPersonResp toResp(JpaPerson model) {
        return JpaPersonResp.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public JpaPerson toModel(JpaPersonReq req) {
        return JpaPerson.builder()
                .name(req.getName())
                .build();
    }
}
