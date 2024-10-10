package com.cludus.clugest.mappers;

import com.cludus.clugest.dtos.N4jEconomicEntityReq;
import com.cludus.clugest.dtos.N4jEconomicEntityResp;
import com.cludus.clugest.model.N4jEconomicEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("neo4j")
@Service
public class Neo4jEconomicEntityMapper {
    public N4jEconomicEntityResp toResp(N4jEconomicEntity model) {
        return N4jEconomicEntityResp.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public N4jEconomicEntity toModel(N4jEconomicEntityReq req) {
        return N4jEconomicEntity.builder()
                .name(req.getName())
                .build();
    }
}
