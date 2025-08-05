package com.autodidacte.autodidacteback.dtos;

import lombok.Data;


import java.util.List;

@Data
public class ProgramParcoursDTO {
    private String progId;
    private String progMatricule;
    private String progIntitule;
    private String progDescription;
    private String progObjectif;
    private String imageUrl;
    private String progCertified;
    private String progDebut;
    private String progEtat;
    private String progression;
    private String progStatus;
    private List<ParcoursDTO> parcoursDTOS;
}
