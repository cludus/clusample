package com.cludus.clugest.services;

import com.cludus.clugest.dtos.EsPostReq;
import com.cludus.clugest.dtos.EsPostResp;
import com.cludus.clugest.mappers.EsPostMapper;
import com.cludus.clugest.repositories.EsPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("elasticsearch")
public class EsPostService {
    @Autowired
    private EsPostRepository repo;

    @Autowired
    private EsPostMapper mapper;

    public EsPostResp createPost(EsPostReq req) {
        var model = mapper.toModel(req);
        repo.save(model);
        return mapper.toResp(model);
    }

    public EsPostResp findPost(String id) {
        return repo.findById(id)
                .map(mapper::toResp)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "post not found"));
    }
}
