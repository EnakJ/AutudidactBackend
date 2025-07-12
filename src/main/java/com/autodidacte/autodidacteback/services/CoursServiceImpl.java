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
    public Page<Cours> findCoursByMotCle(String motCle, int page, int size) {
        return coursRepository.findByMotCle(motCle, PageRequest.of(page, size));
    }

    @Override
    public Page<Cours> findAllCours(int page, int size) {
        return coursRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Cours> findCoursByParcours(Parcours parcours, int page, int size) {
        return coursRepository.findAllByParcours(parcours, PageRequest.of(page, size));
    }
}
