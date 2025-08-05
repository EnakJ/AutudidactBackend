package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Formation {
    @Id
    private String formId;
    @Column(nullable = false, unique = true, length = 150)
    private String formIntitule;
    @Column(nullable = false, unique = true, length = 50)
    private String formMatricule;
    @Column(length = 50)
    private Long formDuree;
    @Column(length = 100)
    private String formCategorie;
    @Column(length = 50)
    private String formStatus;
    private String imageUrl;
    @Column(length = 50)
    private String formEtat;
    private String formDescription;
    @OneToMany(mappedBy = "formation")
    private List<Lesson> lessons;
    @ManyToOne(fetch = FetchType.EAGER)
    private Parcours parcours;
}
