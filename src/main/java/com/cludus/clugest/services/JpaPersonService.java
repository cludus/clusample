package com.cludus.clugest.services;

import com.cludus.clugest.dtos.AcknowledgedResp;
import com.cludus.clugest.dtos.JpaPersonReq;
import com.cludus.clugest.dtos.JpaPersonResp;
import com.cludus.clugest.dtos.PageReq;
import com.cludus.clugest.mappers.JpaPersonMapper;
import com.cludus.clugest.repositories.JpaPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("jpa")
public class JpaPersonService {
    @Autowired
    private JpaPersonRepository repo;

    @Autowired
    private JpaPersonMapper mapper;

    public JpaPersonResp findAll(PageReq page) {
        return null;
    }

    public JpaPersonResp find(long id) {
        return repo.findById(id)
                .map(mapper::toResp)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found"));
    }

    public JpaPersonResp create(JpaPersonReq req) {
        var model = mapper.toModel(req);
        repo.save(model);
        return mapper.toResp(model);
    }

    public JpaPersonResp update(long id, JpaPersonReq req) {
        var model = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found"));
        model.setName(req.getName());
        repo.save(model);
        return mapper.toResp(model);
    }

    public AcknowledgedResp delete(long id) {
        repo.deleteById(id);
        return AcknowledgedResp.builder()
                .acknowledged(true)
                .build();
    }
}
