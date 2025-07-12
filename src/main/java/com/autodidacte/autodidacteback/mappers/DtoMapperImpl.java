package com.autodidacte.autodidacteback.mappers;

import com.autodidacte.autodidacteback.dtos.*;
import com.autodidacte.autodidacteback.entities.*;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class DtoMapperImpl implements DtoMapper {

    @Override
    public CoursDTO fromCours(Cours cours) {
        CoursDTO coursDTO = new CoursDTO();
        copyProperties(cours, coursDTO);

        return coursDTO;
    }

    @Override
    public Cours fromCoursDTO(CoursDTO coursDTO) {
        Cours cours = new Cours();
        copyProperties(coursDTO, cours);

        return cours;
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
}
