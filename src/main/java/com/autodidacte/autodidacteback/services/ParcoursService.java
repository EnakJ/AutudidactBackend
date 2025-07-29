package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ParcoursFormationDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.ParcoursNotFoundException;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;

import java.util.List;


public interface ParcoursService {
    ParcoursDTO getParcoursById(String id) throws ParcoursNotFoundException;
    ParcoursDTO getParcourByMatricule(String matricule) throws ParcoursNotFoundException;
    List<ParcoursDTO> getAllParcours();
    List<ParcoursFormationDTO> getParcoursFormation();
    List<ParcoursDTO> findByMotCle(String motCle) throws ParcoursNotFoundException;
    List<ParcoursDTO> getParcoursByProgram(String programId) throws ParcoursNotFoundException, ProgrammeNotFoundException;
    ParcoursDTO saveParcours(Parcours parcours);
    Parcours updateParcours(Parcours parcours);
    void deleteParcours(String parcoursId) throws ParcoursNotFoundException;
}
