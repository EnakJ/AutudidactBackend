package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.FormationDTO;
import com.autodidacte.autodidacteback.dtos.LessonDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.exceptions.LessonNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.FormationService;
import com.autodidacte.autodidacteback.services.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;
    private final DtoMapper dtoMapper;
    private final FormationService formationService;

    public LessonController(LessonService lessonService,
                            FormationService formationService,
                            DtoMapper dtoMapper)
    {
        this.lessonService = lessonService;
        this.dtoMapper = dtoMapper;
        this.formationService = formationService;
    }

    @GetMapping("")
    public List<LessonDTO> getLessons(){
        List<Lesson> lessons = lessonService.findAllLessons();

        return lessons.stream().map(dtoMapper::fromLesson).toList();
    }

    @GetMapping("/{lessonId}")
    public LessonDTO getLessonById(@PathVariable String lessonId) throws LessonNotFoundException {
        return dtoMapper
                .fromLesson(lessonService.getLessonById(lessonId));
    }

    @GetMapping("/{matricule}")
    public LessonDTO getLessonByMatricule(@PathVariable String matricule) throws LessonNotFoundException{
        return dtoMapper
                .fromLesson(lessonService.getLessonByMatricule(matricule));
    }

    @GetMapping("/{motCle}")
    public List<LessonDTO> getLessonByMotCle(@PathVariable String motCle){
        List<Lesson> lessons = lessonService.findLessonsByMotCle(motCle);

        return lessons.stream().map(dtoMapper::fromLesson).toList();
    }

    @GetMapping("/{formationId}")
    public List<LessonDTO> getLessonByFormation(
            @PathVariable String formationId,
            @RequestBody FormationDTO formationDTO) throws LessonNotFoundException{

        List<Lesson> lessons = lessonService.
                findLessonsByFormation(dtoMapper.fromFormationDTO(formationDTO));

        return lessons.stream().map(dtoMapper::fromLesson).toList();
    }

    @GetMapping("/lessonsByParcours")
    public List<LessonDTO> getLessonByParcours(@RequestBody ParcoursDTO parcoursDTO){
        List<Formation> formationList = formationService
                .findFormationByParcours(dtoMapper.fromParcoursDTO(parcoursDTO));
        List<Lesson> lessonList = new ArrayList<>();

        List<Lesson> collect = formationList.stream().flatMap(cours -> cours.getLessons().stream())
                .distinct()
                .toList();

        return collect.stream().map(dtoMapper::fromLesson).toList();
    }

    @PostMapping("/saveLesson")
    public LessonDTO saveLesson(@RequestBody LessonDTO lessonDTO){
        Lesson lesson = dtoMapper.fromLessonDTO(lessonDTO);

        return dtoMapper.fromLesson(lessonService.saveLesson(lesson));
    }

    @PutMapping("/updateLesson/{lessonId}")
    public LessonDTO updateLesson(@PathVariable String lessonId, @RequestBody LessonDTO lessonDTO){
        Lesson lesson = dtoMapper.fromLessonDTO(lessonDTO);

        return dtoMapper.fromLesson(lessonService.saveLesson(lesson));
    }

    @DeleteMapping("/deleteLesson/{lessonId}")
    public void deleteLesson(@PathVariable String lessonId) throws LessonNotFoundException{
        Lesson lesson = lessonService.getLessonById(lessonId);

        lessonService.deleteLesson(lesson);
    }

}
