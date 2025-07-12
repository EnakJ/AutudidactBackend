package com.autodidacte.autodidacteback.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
public class Programme {
    @Id
    private String id;
    @Column(nullable = false, length = 50)
    private String progMatricule;
    private String progIntitule;
    private String progDescription;
    private String progObjectif;
    @Column(length = 50)
    private String progCertified;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(length = 50)
    private Date progDebut;
    @Column(length = 50)
    private String progEtat;
    @Column(length = 50)
    private String progression;
    @Column(length = 50)
    private String progStatus;
    @OneToMany(mappedBy = "programme")
    private List<Parcours> parcoursList;
}
