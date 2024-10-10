package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.EsPostReq;
import com.cludus.clugest.dtos.EsPostResp;
import com.cludus.clugest.model.EsPost;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("elasticsearch")
@Service
public class EsPostMapper {
    public EsPostResp toResp(EsPost model) {
        return EsPostResp.builder()
                .id(model.getId())
                .title(model.getTitle())
                .content(model.getContent())
                .build();
    }

    public EsPost toModel(EsPostReq req) {
        return EsPost.builder()
                .content(req.getContent())
                .id(req.getId())
                .title(req.getTitle())
                .build();
    }
}
