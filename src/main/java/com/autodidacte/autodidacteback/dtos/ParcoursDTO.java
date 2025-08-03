package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

@Data
public class ParcoursDTO {
    private String parcId;
    private String parcIntitule;
    private String parcMatricule;
    private String parcDescription;
    private String parcObjectif;
    private String imageUrl;
    private String parcDebut;
    private String parcStatus;
    private String parcEtat;
    private String parcCertified;
}
