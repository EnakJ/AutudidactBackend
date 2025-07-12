package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParcoursService {
    Parcours getParcoursById(String id);
    Parcours getParcourByMatricule(String matricule);
    Page<Parcours> findAllParcours(int page, int size);
    @Query("SELECT p FROM Parcours p WHERE p.parcIntitule LIKE :intitule")
    Page<Parcours> findByMotCle(@Param("intitule") String motCle, int page, int size);
}
