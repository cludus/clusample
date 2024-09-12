package com.cludus.clugest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

@Entity
@Table(name = "clugest_real_state_properties")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JpaRealStateProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private JpaPerson person;

    private String address1;

    private String address2;

    private String description;
}
