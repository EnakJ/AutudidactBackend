package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.RessourceDTO;
import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Ressource;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;

import java.util.List;


public interface RessourceService {
    Ressource getRessourceById(String id);
    Ressource getRessourceByMatricule(String matricule);
    List<Ressource> findByMotCle(String motCle);
    List<Ressource> findAllRessources();
    List<Ressource> findRessourceByLesson(Lesson lesson);
    List<Ressource> findRessourcesByCours(Cours cours);
    Ressource saveRessource(Ressource ressource);
    Ressource updateRessource(Ressource ressource);
    void deleteRessource(String ressourceId);
}
