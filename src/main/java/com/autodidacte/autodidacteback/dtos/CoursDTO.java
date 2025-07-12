package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

@Data
public class CoursDTO {
    private String id;
    private String courIntitule;
    private String courMatricule;
    private Long courDuree;
    private String courCategorie;
    private String courStatus;
    private String courEtat;
    private String courDescription;
    private String courType;
    private boolean courOptional;
}
