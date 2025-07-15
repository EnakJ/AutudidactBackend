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
import java.util.UUID;

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
    public List<Ressource> findByMotCle(String motCle) {
        return ressourceRepository.findByRscNameContains(motCle);
    }

    @Override
    public List<Ressource> findAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public List<Ressource> findRessourceByLesson(Lesson lesson) {
        return ressourceRepository.getAllByLesson(lesson);
    }

    @Override
    public List<Ressource> findRessourcesByCours(Cours cours) {
        return ressourceRepository.getByLessonCours(cours);
    }

    @Override
    public Ressource saveRessource(Ressource ressource) {
        ressource.setId(UUID.randomUUID().toString());

        return ressourceRepository.save(ressource);
    }

    @Override
    public Ressource updateRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public void deleteRessource(String ressourceId) {
        ressourceRepository.delete(ressourceRepository.getById(ressourceId));
    }

}
