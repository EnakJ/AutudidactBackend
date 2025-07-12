package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours, String> {
    Cours getCoursById(String id);
    Cours getCoursByCourMatricule(String matricule);
    Page<Cours> findAll(Pageable pageable);
    @Query("SELECT c FROM Cours c WHERE c.courIntitule LIKE :intitule")
    Page<Cours> findByMotCle(@Param("intitule") String motCle, Pageable pageable);
    Page<Cours> findAllByParcours(Parcours parcours, Pageable pageable);
}
