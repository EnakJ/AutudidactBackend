package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Ressource;
import com.autodidacte.autodidacteback.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class RessourceServiceImpl implements RessourceService {
    @Autowired
    private RessourceRepository ressourceRepository;

    @Override
    public Ressource getRessourceById(String id) {
        return ressourceRepository.getById(id);
    }

    @Override
    public Ressource getRessourceByMatricule(String matricule) {
        return ressourceRepository.getByRscMatricule(matricule);
    }

    @Override
    public Page<Ressource> findByMotCle(String motCle, int page, int size) {
        return ressourceRepository.getByMotCle(motCle, PageRequest.of(page, size));
    }

    @Override
    public Page<Ressource> findAllRessources(int page, int size) {
        return ressourceRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Ressource> findRessourceByLesson(Lesson lesson, int page, int size) {
        return ressourceRepository.getAllByLesson(lesson, PageRequest.of(page, size));
    }

    @Override
    public Page<Ressource> findRessourcesByCours(Cours cours, int page, int size) {
        return ressourceRepository.getByLessonCours(cours, PageRequest.of(page, size));
    }

}
