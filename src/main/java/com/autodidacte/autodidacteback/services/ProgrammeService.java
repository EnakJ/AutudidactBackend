package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ProgrammeService {
    Programme getProgramById(String id);
    Programme getProgramByMatricule(String matricule);
    List<Programme> findProgramByMotCle(String motCle);
    List<Programme> findAllPrograms();
    Programme saveProgram(Programme programme);
    Programme updateProgram(Programme programme);
    void deleteProgram(String programId);
}
