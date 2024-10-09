package com.cludus.clugest.services;

import com.cludus.clugest.dtos.EsPostReq;
import com.cludus.clugest.dtos.EsPostResp;
import com.cludus.clugest.repositories.EsPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("elasticsearch")
public class EsPostService {
    @Autowired
    private EsPostRepository repo;

    public EsPostResp createPost(EsPostReq post) {
        return null;
    }
}
