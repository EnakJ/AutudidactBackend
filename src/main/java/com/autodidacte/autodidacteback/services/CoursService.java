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
    @Query("SELECT c FROM Cours c WHERE c.courIntitule LIKE :intitule")
    Page<Cours> findCoursByMotCle(@Param("intitule") String motCle, int page, int size);
    Page<Cours> findAllCours(int page, int size);
    Page<Cours> findCoursByParcours(Parcours parcours, int page, int size);
}
