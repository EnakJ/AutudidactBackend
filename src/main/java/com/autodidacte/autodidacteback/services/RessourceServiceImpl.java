package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Ressource;
import com.autodidacte.autodidacteback.exceptions.LessonNotFoundException;
import com.autodidacte.autodidacteback.exceptions.RessourceNotFoundException;
import com.autodidacte.autodidacteback.repositories.RessourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class RessourceServiceImpl implements RessourceService {
    private final RessourceRepository ressourceRepository;
    private final MatCounterService matCounterService;

    public RessourceServiceImpl(RessourceRepository ressourceRepository, MatCounterService matCounterService) {
        this.ressourceRepository = ressourceRepository;
        this.matCounterService = matCounterService;
    }

    @Override
    public Ressource getRessourceById(String id) throws RessourceNotFoundException {
        return ressourceRepository.getById(id);
    }

    @Override
    public Ressource getRessourceByMatricule(String matricule) throws RessourceNotFoundException {
        return ressourceRepository.getByRscMatricule(matricule);
    }

    @Override
    public List<Ressource> findByMotCle(String motCle) throws RessourceNotFoundException {
        return ressourceRepository.findByRscNameContains(motCle);
    }

    @Override
    public List<Ressource> findAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public List<Ressource> findRessourceByLesson(Lesson lesson) throws LessonNotFoundException {
        return ressourceRepository.getAllByLesson(lesson);
    }

    @Override
    public List<Ressource> findRessourcesByFormation(Formation formation) {
        return ressourceRepository.getByLessonFormation(formation);
    }

    @Override
    public Ressource saveRessource(Ressource ressource) {
        ressource.setRscId(UUID.randomUUID().toString());
        ressource.setRscMatricule(matCounterService.generateMatricule("RSC"));
        return ressourceRepository.save(ressource);
    }

    @Override
    public Ressource updateRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public void deleteRessource(String ressourceId) throws RessourceNotFoundException {
        ressourceRepository.delete(ressourceRepository.getByRscId(ressourceId));
    }

}
