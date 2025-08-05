package com.autodidacte.autodidacteback.mappers;

import com.autodidacte.autodidacteback.dtos.*;
import com.autodidacte.autodidacteback.entities.*;
import com.autodidacte.autodidacteback.repositories.FormationRepository;
import com.autodidacte.autodidacteback.repositories.ParcoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class DtoMapperImpl implements DtoMapper {

    private final ParcoursRepository parcoursRepository;
    private final FormationRepository formationRepository;

    public DtoMapperImpl(
            ParcoursRepository parcoursRepository,
            FormationRepository formationRepository) {
        this.parcoursRepository = parcoursRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public FormationDTO fromFormation(Formation formation) {
        FormationDTO formationDTO = new FormationDTO();
        copyProperties(formation, formationDTO);

        return formationDTO;
    }

    @Override
    public Formation fromFormationDTO(FormationDTO formationDTO) {
        Formation formation = new Formation();
        copyProperties(formationDTO, formation);

        return formation;
    }

    @Override
    public LessonDTO fromLesson(Lesson lesson) {
        LessonDTO lessonDTO = new LessonDTO();
        copyProperties(lesson, lessonDTO);

        return lessonDTO;
    }

    @Override
    public Lesson fromLessonDTO(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        copyProperties(lessonDTO, lesson);

        return lesson;
    }

    @Override
    public RessourceDTO fromRessource(Ressource ressource) {
        RessourceDTO ressourceDTO = new RessourceDTO();
        copyProperties(ressource, ressourceDTO);

        return ressourceDTO;
    }

    @Override
    public Ressource fromRessourceDTO(RessourceDTO ressourceDTO) {
        Ressource ressource = new Ressource();
        copyProperties(ressourceDTO, ressource);

        return ressource;
    }

    @Override
    public ParcoursDTO fromParcours(Parcours parcours) {
        ParcoursDTO parcoursDTO = new ParcoursDTO();
        copyProperties(parcours, parcoursDTO);

        return parcoursDTO;
    }

    @Override
    public Parcours fromParcoursDTO(ParcoursDTO parcoursDTO) {
        Parcours parcours = new Parcours();
        copyProperties(parcoursDTO, parcours);

        return parcours;
    }

    @Override
    public ProgrammeDTO fromProgram(Programme programme) {
        ProgrammeDTO programmeDTO = new ProgrammeDTO();
        copyProperties(programme, programmeDTO);

        return programmeDTO;
    }

    @Override
    public Programme fromProgramDTO(ProgrammeDTO programmeDTO) {
        Programme programme = new Programme();
        copyProperties(programmeDTO, programme);

        return programme;
    }

    @Override
    public ProgramParcoursDTO toProgramParcoursDTO(Programme programme) {
        ProgramParcoursDTO programParcoursDTO = new ProgramParcoursDTO();
        copyProperties(programme, programParcoursDTO);

        programParcoursDTO.setParcoursDTOS(
                programme.getParcoursList().stream().map(this::fromParcours)
                .toList()
        );

        return programParcoursDTO;
    }

    @Override
    public ProgramParcoursDTO toProgramParcoursDTO(ProgrammeDTO programmeDTO) {
        List<ParcoursDTO> parcoursDTOS =
                parcoursRepository.findByProgramme(this.fromProgramDTO(programmeDTO))
                        .stream()
                        .map(this::fromParcours)
                        .toList();

        ProgramParcoursDTO programParcoursDTO = this.toProgramParcoursDTO(programmeDTO);
        programParcoursDTO.setParcoursDTOS(parcoursDTOS);

        return programParcoursDTO;
    }

    @Override
    public Programme fromProgramParcoursDTO(ProgramParcoursDTO programParcoursDTO) {
        Programme programme = new Programme();
        copyProperties(programParcoursDTO, programme);

        return programme;
    }

    @Override
    public ParcoursFormationDTO toParcoursFormationDTO(Parcours parcours) {
        ParcoursFormationDTO parcoursFormationDTO = new ParcoursFormationDTO();
        copyProperties(parcours, parcoursFormationDTO);

        parcoursFormationDTO.setFormationDTOS(parcours.getFormationList()
                .stream()
                .map(this::fromFormation).toList());


        return parcoursFormationDTO;
    }

    @Override
    public ParcoursFormationDTO toParcoursFormationDTO(ParcoursDTO parcoursDTO) {
        ParcoursFormationDTO parcoursFormationDTO = new ParcoursFormationDTO();
        List<Formation> formationList = formationRepository
                .findAllByParcours(this.fromParcoursDTO(parcoursDTO));

        copyProperties(parcoursDTO, parcoursFormationDTO);

        parcoursFormationDTO.setFormationDTOS(
                formationList.stream().map(this::fromFormation).toList()
        );

        return parcoursFormationDTO;
    }

    @Override
    public Parcours fromParcoursFormationDTO(ParcoursFormationDTO parcoursFormationDTO) {
        return parcoursRepository
                .getReferenceById(parcoursFormationDTO.getParcId());
    }

}
