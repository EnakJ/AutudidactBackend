package com.autodidacte.autodidacteback.services;

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
    public Page<Lesson> findLessonsByMotCle(String motCle, int page, int size) {
        return lessonRepository.findByMotCle(motCle, PageRequest.of(page, size));
    }

    @Override
    public Page<Lesson> findAllLessons(int page, int size) {
        return lessonRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Lesson> findLessonsByCours(Cours cours, int page, int size) {
        return lessonRepository.findAllByCours(cours, PageRequest.of(page, size));
    }

    @Override
    public Page<Lesson> findLessonByParcours(Parcours parcours, int page, int size) {
        return lessonRepository.findAllByCours_Parcours(parcours, PageRequest.of(page, size));
    }
}
