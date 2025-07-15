package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.repositories.ParcoursRepository;
import com.autodidacte.autodidacteback.repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service @Transactional
public class ParcoursServiceImpl implements ParcoursService {
    @Autowired
    private ParcoursRepository parcoursRepository;
    @Autowired
    private ProgrammeRepository programmeRepository;

    @Override
    public Parcours getParcoursById(String id) {
        return parcoursRepository.findById(id).orElseThrow();
    }

    @Override
    public Parcours getParcourByMatricule(String matricule) {
        return parcoursRepository.findByParcMatricule(matricule);
    }

    @Override
    public List<Parcours> findAll() {
        return parcoursRepository.findAll();
    }

    @Override
    public List<Parcours> findByMotCle(String motCle) {
        return parcoursRepository.findByParcIntituleContains(motCle);
    }

    @Override
    public List<Parcours> getParcoursByProgram(String programId) {
        Programme programme = programmeRepository.findById(programId).orElseThrow();

        return parcoursRepository.findByProgramme(programme);
    }

    @Override
    public Parcours saveParcours(Parcours parcours) {
        parcours.setId(UUID.randomUUID().toString());
        return parcoursRepository.save(parcours);
    }

    @Override
    public Parcours updateParcours(Parcours parcours) {
        return parcoursRepository.save(parcours);
    }

    @Override
    public void deleteParcours(String parcoursId) {
        Parcours parcours = parcoursRepository.findById(parcoursId).orElseThrow();
        parcoursRepository.delete(parcours);
    }
}
