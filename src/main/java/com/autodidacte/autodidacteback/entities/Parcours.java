package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Parcours {
    @Id
    private String id;
    @Column(length = 150, nullable = false)
    private String parcIntitule;
    @Column(length = 50, nullable = false)
    private String parcMatricule;
    private String parcDescription;
    private String parcObjectif;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date parcDebut;
    @Column(length = 50)
    private String parcStatus;
    @Column(length = 50)
    private String parcEtat;
    @Column(length = 50)
    private String parcCertified;
    @OneToMany(mappedBy = "parcours")
    private List<Cours> coursList;
    @ManyToOne
    private Programme programme;
}
