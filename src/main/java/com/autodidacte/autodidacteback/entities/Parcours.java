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
    private String parcId;
    @Column(length = 150, unique = true, nullable = false)
    private String parcIntitule;
    @Column(length = 50, unique = true, nullable = false)
    private String parcMatricule;
    private String parcDescription;
    private String parcObjectif;
    @Column(length = 100)
    private String imageUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date parcDebut;
    @Column(length = 50)
    private String parcStatus;
    @Column(length = 50)
    private String parcEtat;
    @Column(length = 50)
    private String parcCertified;
    @OneToMany(mappedBy = "parcours")
    private List<Formation> formationList;
    @ManyToOne
    private Programme programme;
}
