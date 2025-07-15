package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CoursService {
    Cours getCoursById(String id);
    Cours getCoursByMatricule(String matricule);
    List<Cours> findCoursByMotCle(String motCle);
    List<Cours> findAllCours();
    List<Cours> findCoursByParcours(Parcours parcours);
    Cours saveCours(Cours cours);
    Cours updateCours(Cours cours);
    void deleteCours(String coursId);
}
