package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ProgramParcoursDTO;
import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ProgrammeService {
    ProgrammeDTO getProgramById(String id) throws ProgrammeNotFoundException;
    ProgramParcoursDTO getProgramParcoursById(String programId) throws ProgrammeNotFoundException;
    ProgrammeDTO getProgramByMatricule(String matricule) throws ProgrammeNotFoundException;
    List<ProgramParcoursDTO> findProgramByMotCle(String motCle);
    List<ProgrammeDTO> findAllPrograms();
    List<ProgramParcoursDTO> getAllProgramsWithParcours();
    ProgrammeDTO saveProgram(Programme programme);
    ProgramParcoursDTO updateProgram(Programme programme);
    void deleteProgram(String programId) throws ProgrammeNotFoundException;
}
