package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class ProgrammeServiceImpl implements ProgrammeService {
    @Autowired
    private ProgrammeRepository programmeRepository;
    @Override
    public Programme getProgramById(String id) {
        return programmeRepository.getById(id);
    }

    @Override
    public Programme getProgramByMatricule(String matricule) {
        return programmeRepository.findByProgMatricule(matricule);
    }

    @Override
    public Page<Programme> findProgramByMotCle(String motCle, int page, int size) {
        return programmeRepository.findByMotCle(motCle, PageRequest.of(page, size));
    }

    @Override
    public Page<Programme> findAllPrograms(int page, int size) {
        return programmeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Programme saveProgram(Programme programme) {
        return programmeRepository.save(programme);
    }

    @Override
    public Programme updateProgram(Programme programme) {
        return programmeRepository.save(programme);
    }

    @Override
    public void deleteProgram(String programId) {
        Programme programme = programmeRepository.getById(programId);
        programmeRepository.delete(programme);
    }


}
