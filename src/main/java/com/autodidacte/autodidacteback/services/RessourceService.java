package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Ressource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RessourceService {
    Ressource getRessourceById(String id);
    Ressource getRessourceByMatricule(String matricule);
    @Query("SELECT r FROM Ressource r WHERE r.rscName LIKE :name")
    Page<Ressource> findByMotCle(@Param("name") String motCle, int page, int size);
    Page<Ressource> findAllRessources(int page, int size);
    Page<Ressource> findRessourceByLesson(Lesson lesson, int page, int size);
    Page<Ressource> findRessourcesByCours(Cours cours, int page, int size);
}
