package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

@Data
public class FormationDTO {
    private String formId;
    private String formIntitule;
    private String formMatricule;
    private Long formDuree;
    private String formCategorie;
    private String formStatus;
    private String imageUrl;
    private String formEtat;
    private String formDescription;
    private String formType;
}
