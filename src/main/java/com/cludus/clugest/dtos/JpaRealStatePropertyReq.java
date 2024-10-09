package com.cludus.clugest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JpaRealStatePropertyReq {
    private Long id;

    private Long personId;

    private String address1;

    private String address2;

    private String description;
}
