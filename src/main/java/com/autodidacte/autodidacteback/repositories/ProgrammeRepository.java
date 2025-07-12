package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, String> {
    Programme getById(String id);
    Programme findByProgMatricule(String matricule);
    Page<Programme> findAll(Pageable pageable);
    @Query("SELECT p FROM Programme p WHERE p.progIntitule LIKE :intitule")
    Page<Programme> findByMotCle(@Param("intitule") String motCle, Pageable pageable);
}
