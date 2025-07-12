package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.repositories.ParcoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class ParcoursServiceImpl implements ParcoursService {
    @Autowired
    private ParcoursRepository parcoursRepository;
    @Override
    public Parcours getParcoursById(String id) {
        return parcoursRepository.getById(id);
    }

    @Override
    public Parcours getParcourByMatricule(String matricule) {
        return parcoursRepository.findByParcMatricule(matricule);
    }

    @Override
    public Page<Parcours> findAllParcours(int page, int size) {
        return parcoursRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Parcours> findByMotCle(String motCle, int page, int size) {
        return parcoursRepository.findByMotCle(motCle, PageRequest.of(page, size));
    }
}
