package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.LessonNotFoundException;

import java.util.List;

public interface LessonService {
    Lesson getLessonById(String id) throws LessonNotFoundException;
    Lesson getLessonByMatricule(String matricule) throws LessonNotFoundException;
    List<Lesson> findLessonsByMotCle(String motCle);
    List<Lesson> findAllLessons();
    List<Lesson> findLessonsByFormation(Formation formation) throws LessonNotFoundException;
    List<Lesson> findLessonByParcours(Parcours parcours);
    Lesson saveLesson(Lesson lesson);
    Lesson updateLesson(String lessonId, Lesson lesson);
    void deleteLesson(Lesson lesson);
}
