package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Cours {
    @Id
    private String id;
    @Column(nullable = false, length = 150)
    private String courIntitule;
    @Column(nullable = false, length = 50)
    private String courMatricule;
    @Column(length = 50)
    private Long courDuree;
    @Column(length = 100)
    private String courCategorie;
    @Column(length = 50)
    private String courStatus;
    @Column(length = 50)
    private String courEtat;
    private String courDescription;
    @Column(length = 20)
    private boolean courOptional;
    @OneToMany(mappedBy = "cours")
    private List<Lesson> lessons;
    @ManyToOne(fetch = FetchType.EAGER)
    private Parcours parcours;
}
