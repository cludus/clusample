package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.JpaRealStatePropertyReq;
import com.cludus.clugest.dtos.JpaRealStatePropertyResp;
import com.cludus.clugest.model.JpaRealStateProperty;
import com.cludus.clugest.repositories.JpaPersonRepository;
import org.springframework.stereotype.Service;

@Service
public class JpaRealStatePropertyMapper {

    private JpaPersonRepository personRepo;

    public JpaRealStatePropertyResp toResp(JpaRealStateProperty model) {
        return JpaRealStatePropertyResp.builder()
                .id(model.getId())
                .build();
    }

    public JpaRealStateProperty toModel(JpaRealStatePropertyReq req) {
        return JpaRealStateProperty.builder()
                .id(req.getId())
                .address1(req.getAddress1())
                .address2(req.getAddress2())
                .description(req.getDescription())
                .person(personRepo.findById(req.getPersonId()).get())
                .build();
    }
}
