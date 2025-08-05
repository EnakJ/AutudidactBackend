package com.autodidacte.autodidacteback.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ProgrammeDTO {
    private String progId;
    private String progMatricule;
    private String progIntitule;
    private String progDescription;
    private String progObjectif;
    private String imageUrl;
    private String progCertified;
    private Date progDebut;
    private String progEtat;
    private String progression;
    private String progStatus;
}
