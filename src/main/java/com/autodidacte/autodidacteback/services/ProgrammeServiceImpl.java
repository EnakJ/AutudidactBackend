package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.dtos.ProgramParcoursDTO;
import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.repositories.ProgrammeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service @Transactional
public class ProgrammeServiceImpl implements ProgrammeService {
    private final DtoMapper dtoMapper;
    private final MatCounterService matCounterService;
    private final ProgrammeRepository programmeRepository;

    public ProgrammeServiceImpl(
            DtoMapper dtoMapper,
            MatCounterService matCounterService,
            ProgrammeRepository programmeRepository) {
        this.dtoMapper = dtoMapper;
        this.matCounterService = matCounterService;
        this.programmeRepository = programmeRepository;
    }

    @Override
    public ProgrammeDTO getProgramById(String idProgram) throws ProgrammeNotFoundException {
        return dtoMapper.fromProgram(programmeRepository.findById(idProgram).orElseThrow());
    }

    @Override
    public ProgramParcoursDTO getProgramParcoursById(String programId) throws ProgrammeNotFoundException {
        return dtoMapper.toProgramParcoursDTO(
                programmeRepository.getReferenceById(programId)
        );

    }

    @Override
    public ProgrammeDTO getProgramByMatricule(String matricule) throws ProgrammeNotFoundException {
        return dtoMapper.fromProgram(
                programmeRepository.findByProgMatricule(matricule)
        );
    }

    @Override
    public List<ProgramParcoursDTO> findProgramByMotCle(String motCle) {
        List<Programme> programmes = programmeRepository
                .findByProgIntituleContains("%"+ motCle + "%");

        return programmes.stream().map(program -> {
            List<ParcoursDTO> parcoursDTOS = program.getParcoursList()
                    .stream().map(dtoMapper::fromParcours).toList();

            ProgramParcoursDTO programParcoursDTO = dtoMapper.toProgramParcoursDTO(program);
                    programParcoursDTO.setParcoursDTOS(parcoursDTOS);

            return programParcoursDTO;
        })
                .collect(Collectors.toList());

    }

    @Override
    public List<ProgrammeDTO> findAllPrograms() {

        return programmeRepository.findAll()
                .stream()
                .map(dtoMapper::fromProgram).toList();
    }

    @Override
    public List<ProgramParcoursDTO> getAllProgramsWithParcours() {
        List<Programme> programmes = programmeRepository.findAll();

        return programmes.stream().map(dtoMapper::toProgramParcoursDTO).toList();
    }

    @Override
    public ProgrammeDTO saveProgram(Programme programme) {
        log.info("Saving programme...");
        programme.setProgId(UUID.randomUUID().toString());
        programme.setProgMatricule(matCounterService.generateMatricule("PRG"));
        return dtoMapper
                .fromProgram(programmeRepository.save(programme));
    }

    @Override
    public ProgramParcoursDTO updateProgram(Programme programme) {
        log.info("Updating programme...");
        return dtoMapper
                .toProgramParcoursDTO(programmeRepository.save(programme));
    }

    @Override
    public void deleteProgram(String programId) throws ProgrammeNotFoundException {
        log.info("Deleting programme...");
        Programme programme = programmeRepository.getReferenceById(programId);
        programmeRepository.delete(programme);
    }


}
