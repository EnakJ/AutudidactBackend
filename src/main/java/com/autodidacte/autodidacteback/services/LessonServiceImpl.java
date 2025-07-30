package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.LessonNotFoundException;
import com.autodidacte.autodidacteback.repositories.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final MatCounterService matCounterService;

    public LessonServiceImpl(
            LessonRepository lessonRepository,
            MatCounterService matCounterService) {
        this.lessonRepository = lessonRepository;
        this.matCounterService = matCounterService;
    }

    @Override
    public Lesson getLessonById(String id) throws LessonNotFoundException {
        return lessonRepository.getById(id);
    }

    @Override
    public Lesson getLessonByMatricule(String matricule) throws LessonNotFoundException {
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
    public List<Lesson> findLessonsByFormation(Formation formation) throws LessonNotFoundException {
        return lessonRepository.findAllByFormation(formation);
    }

    @Override
    public List<Lesson> findLessonByParcours(Parcours parcours) {
        return lessonRepository.findAllByFormation_Parcours(parcours);
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        lesson.setId(UUID.randomUUID().toString());
        lesson.setLessonMatricule(matCounterService.generateMatricule("LES"));
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
