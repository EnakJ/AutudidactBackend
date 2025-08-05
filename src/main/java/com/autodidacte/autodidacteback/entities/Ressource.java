package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Ressource {
    @Id
    private String rscId;
    @Column(nullable = false)
    private String rscName;
    @Column(length = 50, unique = true, nullable = false)
    private String rscMatricule;
    @Column(length = 50)
    private String rscType;
    @Column(length = 50)
    private String rscStatus;
    @Column(length = 20)
    private Long rscDuree;
    private String rscLien;
    private boolean rscLocal;
    @ManyToOne
    private Lesson lesson;
}
