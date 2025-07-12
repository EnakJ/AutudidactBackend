package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonService {
    Lesson getLessonById(String id);
    Lesson getLessonByMatricule(String matricule);
    @Query("SELECT l FROM Lesson l WHERE l.lessonTitre LIKE :titre")
    Page<Lesson> findLessonsByMotCle(@Param("titre") String motCle, int page, int size);
    Page<Lesson> findAllLessons(int page, int size);
    Page<Lesson> findLessonsByCours(Cours cours, int page, int size);
    Page<Lesson> findLessonByParcours(Parcours parcours, int page, int size);
}
