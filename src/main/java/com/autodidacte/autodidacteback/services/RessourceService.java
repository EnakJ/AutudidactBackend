package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Ressource;
import com.autodidacte.autodidacteback.exceptions.LessonNotFoundException;
import com.autodidacte.autodidacteback.exceptions.RessourceNotFoundException;

import java.util.List;


public interface RessourceService {
    Ressource getRessourceById(String id) throws RessourceNotFoundException;
    Ressource getRessourceByMatricule(String matricule) throws RessourceNotFoundException;
    List<Ressource> findByMotCle(String motCle) throws RessourceNotFoundException;
    List<Ressource> findAllRessources();
    List<Ressource> findRessourceByLesson(Lesson lesson) throws LessonNotFoundException;
    List<Ressource> findRessourcesByFormation(Formation formation);
    Ressource saveRessource(Ressource ressource);
    Ressource updateRessource(Ressource ressource);
    void deleteRessource(String ressourceId) throws RessourceNotFoundException;
}
