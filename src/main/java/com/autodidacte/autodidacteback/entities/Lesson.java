package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Lesson {
    @Id
    private String id;
    @Column(length = 150, nullable = false)
    private String lessonTitre;
    @Column(length = 50, nullable = false)
    private String lessonMatricule;
    private Long lessonDuree;
    @Column(length = 50)
    private String lessonType;
    @Column(length = 50)
    private String lessonStatus;
    @OneToMany(mappedBy = "lesson")
    private List<Ressource> ressources;
    @ManyToOne
    private Cours cours;
}
