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
import java.util.Optional;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcours, String> {
    Optional<Parcours> findByParcId(String id);
    Parcours findByParcMatricule(String matricule);
    List<Parcours> findAll();
    List<Parcours> findByParcIntituleContains(String motCle);
    List<Parcours> findByProgramme(Programme programme);
}
