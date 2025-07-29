package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ParcoursFormationDTO {
    private String parcoursId;
    private String parcIntitule;
    private String parcMatricule;
    private String parcDescription;
    private String parcObjectif;
    private String parcDebut;
    private String parcStatus;
    private String parcEtat;
    private String parcCertified;
    private List<FormationDTO> formationDTOS;
}
