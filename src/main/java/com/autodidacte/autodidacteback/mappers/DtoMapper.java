package com.autodidacte.autodidacteback.mappers;

import com.autodidacte.autodidacteback.dtos.*;
import com.autodidacte.autodidacteback.entities.*;

public interface DtoMapper {
    CoursDTO fromCours(Cours cours);
    Cours fromCoursDTO(CoursDTO coursDTO);
    LessonDTO fromLesson(Lesson lesson);
    Lesson fromLessonDTO(LessonDTO lessonDTO);
    RessourceDTO fromRessource(Ressource ressource);
    Ressource fromRessourceDTO(RessourceDTO ressourceDTO);
    ParcoursDTO fromParcours(Parcours parcours);
    Parcours fromParcoursDTO(ParcoursDTO parcoursDTO);
    ProgrammeDTO fromProgram(Programme programme);
    Programme fromProgramDTO(ProgrammeDTO programmeDTO);
}
