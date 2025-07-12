package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Cours {
    @Id
    private String id;
    private String courIntitule;
    private String courMatricule;
    private Long courDuree;
    private String courCategorie;
    private String courStatus;
    private String courEtat;
    private String courDescription;
    private boolean courOptional;
    @OneToMany(mappedBy = "cours")
    private List<Lesson> lessons;
    @ManyToOne
    private Parcours parcours;
}
