package com.cludus.clugest.services;

import com.cludus.clugest.dtos.*;
import com.cludus.clugest.mappers.JpaRealStatePropertyMapper;
import com.cludus.clugest.repositories.JpaRealStatePropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("jpa")
public class JpaRealStatePropertyService {

    @Autowired
    private JpaRealStatePropertyRepository repo;

    @Autowired
    private JpaRealStatePropertyMapper mapper;

    public JpaRealStatePropertyResp findAll(PageReq page) {
        return null;
    }

    public JpaRealStatePropertyResp find(long id) {
        return repo.findById(id)
                .map(mapper::toResp)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "real state property not found"));
    }

    public JpaRealStatePropertyResp create(JpaRealStatePropertyReq req) {
        var model = mapper.toModel(req);
        repo.save(model);
        return mapper.toResp(model);
    }

    public JpaRealStatePropertyResp update(long id, JpaRealStatePropertyReq req) {
        var model = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "real state property not found"));
        model.setAddress1(req.getAddress1());
        model.setAddress2(req.getAddress2());
        model.setDescription(req.getDescription());
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
