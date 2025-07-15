package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.LessonDTO;
import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.repositories.CoursRepository;
import com.autodidacte.autodidacteback.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public Lesson getLessonById(String id) {
        return lessonRepository.getById(id);
    }

    @Override
    public Lesson getLessonByMatricule(String matricule) {
        return lessonRepository.getByLessonMatricule(matricule);
    }

    @Override
    public List<Lesson> findLessonsByMotCle(String motCle) {
        return lessonRepository.findByLessonTitreContains(motCle);
    }

    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> findLessonsByCours(Cours cours) {
        return lessonRepository.findAllByCours(cours);
    }

    @Override
    public List<Lesson> findLessonByParcours(Parcours parcours) {
        return lessonRepository.findAllByCours_Parcours(parcours);
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        lesson.setId(UUID.randomUUID().toString());

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLesson(String lessonId, Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Lesson lesson) {
        lessonRepository.delete(lesson);
    }
}
