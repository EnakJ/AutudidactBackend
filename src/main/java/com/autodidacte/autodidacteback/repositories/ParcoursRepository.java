package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, String> {
    Parcours getById(String id);
    Parcours findByParcMatricule(String matricule);
    Page<Parcours> findAll(Pageable pageable);
    @Query("SELECT p FROM Parcours p WHERE p.parcIntitule LIKE :intitule")
    Page<Parcours> findByMotCle(@Param("intitule")String motCle, Pageable pageable);
    Page<Parcours> findAllByProgramme(Programme programme, Pageable pageable);
}
