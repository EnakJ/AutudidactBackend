package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ParcoursFormationDTO {
    private String parcId;
    private String parcIntitule;
    private String parcMatricule;
    private String parcDescription;
    private String parcObjectif;
    private String imageUrl;
    private Date parcDebut;
    private String parcStatus;
    private String parcEtat;
    private String parcCertified;
    private List<FormationDTO> formationDTOS;
}
