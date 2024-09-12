package com.cludus.clugest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

@Entity
@Table(name = "clugest_persons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JpaPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
