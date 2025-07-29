package com.autodidacte.autodidacteback.mappers;

import com.autodidacte.autodidacteback.dtos.*;
import com.autodidacte.autodidacteback.entities.*;

public interface DtoMapper {
    FormationDTO fromFormation(Formation formation);
    Formation fromFormationDTO(FormationDTO formationDTO);
    LessonDTO fromLesson(Lesson lesson);
    Lesson fromLessonDTO(LessonDTO lessonDTO);
    RessourceDTO fromRessource(Ressource ressource);
    Ressource fromRessourceDTO(RessourceDTO ressourceDTO);
    ParcoursDTO fromParcours(Parcours parcours);
    Parcours fromParcoursDTO(ParcoursDTO parcoursDTO);
    ProgrammeDTO fromProgram(Programme programme);
    Programme fromProgramDTO(ProgrammeDTO programmeDTO);
    ProgramParcoursDTO toProgramParcoursDTO(Programme programme);
    ProgramParcoursDTO toProgramParcoursDTO(ProgrammeDTO programmeDTO);
    Programme fromProgramParcoursDTO(ProgramParcoursDTO programParcoursDTO);
    ParcoursFormationDTO toParcoursFormationDTO(Parcours parcours);
    ParcoursFormationDTO toParcoursFormationDTO(ParcoursDTO parcoursDTO);
    Parcours fromParcoursFormationDTO(ParcoursFormationDTO parcoursFormationDTO);
}
