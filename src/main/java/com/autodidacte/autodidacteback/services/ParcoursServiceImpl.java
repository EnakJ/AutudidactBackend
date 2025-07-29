package com.autodidacte.autodidacteback.services;

import com.autodidacte.autodidacteback.dtos.FormationDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursFormationDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.exceptions.ParcoursNotFoundException;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.repositories.ParcoursRepository;
import com.autodidacte.autodidacteback.repositories.ProgrammeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service @Transactional
public class ParcoursServiceImpl implements ParcoursService {

    private final ParcoursRepository parcoursRepository;
    private final ProgrammeRepository programmeRepository;
    private final DtoMapper dtoMapper;

    public ParcoursServiceImpl(
            ParcoursRepository parcoursRepository,
            ProgrammeRepository programmeRepository,
            DtoMapper dtoMapper)
    {
        this.parcoursRepository = parcoursRepository;
        this.programmeRepository = programmeRepository;
        this.dtoMapper = dtoMapper;
    }


    @Override
    public ParcoursDTO getParcoursById(String id) throws ParcoursNotFoundException {
        return this.dtoMapper
                .fromParcours(parcoursRepository.getReferenceById(id));
    }

    @Override
    public ParcoursDTO getParcourByMatricule(String matricule) throws ParcoursNotFoundException {
        return this.dtoMapper
                .fromParcours(parcoursRepository.findByParcMatricule(matricule));
    }

    @Override
    public List<ParcoursDTO> getAllParcours() {
        return parcoursRepository.findAll().stream().map(dtoMapper::fromParcours)
                .toList();
    }

    @Override
    public List<ParcoursFormationDTO> getParcoursFormation() {
        List<Parcours> parcoursList = parcoursRepository.findAll();

        return parcoursList.stream().map(parcours -> {
            List<FormationDTO> formationDTOS = parcours.getFormationList().stream().map(dtoMapper::fromFormation)
                    .toList();

            ParcoursFormationDTO parcoursFormationDTO = dtoMapper.toParcoursFormationDTO(parcours);
            parcoursFormationDTO.setFormationDTOS(formationDTOS);

            return parcoursFormationDTO;

        }).collect(Collectors.toList());
    }

    @Override
    public List<ParcoursDTO> findByMotCle(String motCle) throws ParcoursNotFoundException {
        return parcoursRepository.findByParcIntituleContains(motCle)
                .stream().map(dtoMapper::fromParcours)
                .toList();
    }

    @Override
    public List<ParcoursDTO> getParcoursByProgram(String programId) throws ParcoursNotFoundException, ProgrammeNotFoundException {
        Programme programme = programmeRepository.getReferenceById(programId);

        return parcoursRepository.findByProgramme(programme)
                .stream().map(dtoMapper::fromParcours).toList();
    }

    @Override
    public ParcoursDTO saveParcours(Parcours parcours) {
        log.info("Saving parcours...");
        parcours.setId(UUID.randomUUID().toString());
        return dtoMapper.fromParcours(parcoursRepository.save(parcours));
    }

    @Override
    public Parcours updateParcours(Parcours parcours) {
        log.info("Updating parcours...");
        return parcoursRepository.save(parcours);
    }

    @Override
    public void deleteParcours(String parcoursId) throws ParcoursNotFoundException {
        log.info("Deleting parcours...");
        Parcours parcours = parcoursRepository.findById(parcoursId).orElseThrow();
        parcoursRepository.delete(parcours);
    }
}
