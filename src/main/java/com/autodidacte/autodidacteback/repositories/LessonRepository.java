package com.autodidacte.autodidacteback.repositories;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {
    Lesson getById(String id);
    Page<Lesson> findAll(Pageable pageable);
    @Query("SELECT l FROM Lesson l WHERE L.lessonTitre LIKE :t")
    Page<Lesson> findByMotCle(@Param("t")String titre, Pageable pageable);
    Lesson getByLessonMatricule(String matricule);
    Page<Lesson> findAllByCours(Cours cours, Pageable pageable);
    Page<Lesson> findAllByCours_Parcours(Parcours parcours, Pageable pageable);
}
