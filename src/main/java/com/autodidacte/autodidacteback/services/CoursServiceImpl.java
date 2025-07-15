package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class CoursServiceImpl implements CoursService {
    @Autowired
    private CoursRepository coursRepository;
    @Override
    public Cours getCoursById(String id) {
        Cours cours = coursRepository.getCoursById(id);
        return cours;
    }

    @Override
    public Cours getCoursByMatricule(String matricule) {
        Cours cours = coursRepository.getCoursByCourMatricule(matricule);
        return cours;
    }

    @Override
    public List<Cours> findCoursByMotCle(String motCle) {
        return coursRepository.findByCourIntituleContains(motCle);
    }

    @Override
    public List<Cours> findAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public List<Cours> findCoursByParcours(Parcours parcours) {
        return coursRepository.findAllByParcours(parcours);
    }

    @Override
    public Cours saveCours(Cours cours) {
        cours.setId(UUID.randomUUID().toString());
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public void deleteCours(String coursId) {
        coursRepository.deleteById(coursId);
    }
}
