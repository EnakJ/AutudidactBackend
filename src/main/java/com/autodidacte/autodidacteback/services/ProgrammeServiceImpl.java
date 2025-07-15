package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.exceptions.NotFoundProgrammeException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.repositories.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service @Transactional
public class ProgrammeServiceImpl implements ProgrammeService {
    @Autowired
    private DtoMapper dtoMapper;

    @Autowired
    private ProgrammeRepository programmeRepository;
    @Override
    public Programme getProgramById(String id) {
            return programmeRepository.findById(id).orElseThrow();
    }

    @Override
    public Programme getProgramByMatricule(String matricule) {
        return programmeRepository.findByProgMatricule(matricule);
    }

    @Override
    public List<Programme> findProgramByMotCle(String motCle) {
        return programmeRepository.findByProgIntituleContains(motCle);
    }

    @Override
    public List<Programme> findAllPrograms() {

        return programmeRepository.findAll();
    }

    @Override
    public Programme saveProgram(Programme programme) {

        programme.setId(UUID.randomUUID().toString());

        return programmeRepository.save(programme);
    }

    @Override
    public Programme updateProgram(Programme programme) {
        return programmeRepository.save(programme);
    }

    @Override
    public void deleteProgram(String programId) {
        Programme programme = programmeRepository.findById(programId).orElseThrow();
        programmeRepository.delete(programme);
    }


}
