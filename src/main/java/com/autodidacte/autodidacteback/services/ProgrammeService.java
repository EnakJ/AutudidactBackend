package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

public interface ProgrammeService {
    Programme getProgramById(String id);
    Programme getProgramByMatricule(String matricule);
    @Query("SELECT p FROM Programme p WHERE p.progIntitule LIKE :intitule")
    Page<Programme> findProgramByMotCle(@Param("intitule") String motCle, int page, int size);
    Page<Programme> findAllPrograms(int page, int size);
    Programme saveProgram(Programme programme);
    Programme updateProgram(Programme programme);
    void deleteProgram(String programId);
}
