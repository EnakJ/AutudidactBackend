package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.LessonDTO;
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
    List<Lesson> findLessonsByMotCle(String motCle);
    List<Lesson> findAllLessons();
    List<Lesson> findLessonsByCours(Cours cours);
    List<Lesson> findLessonByParcours(Parcours parcours);
    Lesson saveLesson(Lesson lesson);
    Lesson updateLesson(String lessonId, Lesson lesson);
    void deleteLesson(Lesson lesson);
}
