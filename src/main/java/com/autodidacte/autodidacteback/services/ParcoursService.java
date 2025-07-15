package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ParcoursService {
    Parcours getParcoursById(String id);
    Parcours getParcourByMatricule(String matricule);
    List<Parcours> findAll();
    List<Parcours> findByMotCle(String motCle);
    List<Parcours> getParcoursByProgram(String programId);
    Parcours saveParcours(Parcours parcours);
    Parcours updateParcours(Parcours parcours);
    void deleteParcours(String parcoursId);
}
