package com.cludus.clugest.services;

import com.cludus.clugest.dtos.CassChatMessageReq;
import com.cludus.clugest.dtos.CassChatMessageResp;
import com.cludus.clugest.mappers.CassChatMessageMapper;
import com.cludus.clugest.repositories.CassChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Profile("cassandra")
public class CassChatMessageService {
    @Autowired
    private CassChatMessageRepository repo;

    @Autowired
    private CassChatMessageMapper mapper;

    public CassChatMessageResp add(CassChatMessageReq req) {
        var result = mapper.toModel(req);
        if(req.getId() == null) {
            result.setId(UUID.randomUUID().toString());
        }
        result = repo.save(result);
        return mapper.toResp(result);
    }
}
