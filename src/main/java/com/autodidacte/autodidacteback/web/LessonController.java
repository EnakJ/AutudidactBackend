package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.CoursDTO;
import com.autodidacte.autodidacteback.dtos.LessonDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.CoursService;
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
    private final CoursService coursService;

    public LessonController(LessonService lessonService,
                            CoursService coursService,
                            DtoMapper dtoMapper)
    {
        this.lessonService = lessonService;
        this.dtoMapper = dtoMapper;
        this.coursService = coursService;
    }

    @GetMapping("")
    public List<LessonDTO> getLessons(){
        List<Lesson> lessons = lessonService.findAllLessons();

        return lessons.stream().map(dtoMapper::fromLesson).toList();
    }

    @GetMapping("/{lessonId}")
    public LessonDTO getLessonById(@PathVariable String lessonId){
        return dtoMapper
                .fromLesson(lessonService.getLessonById(lessonId));
    }

    @GetMapping("/{matricule}")
    public LessonDTO getLessonByMatricule(@PathVariable String matricule){
        return dtoMapper
                .fromLesson(lessonService.getLessonByMatricule(matricule));
    }

    @GetMapping("/{motCle}")
    public List<LessonDTO> getLessonByMotCle(@PathVariable String motCle){
        List<Lesson> lessons = lessonService.findLessonsByMotCle(motCle);

        return lessons.stream().map(dtoMapper::fromLesson).toList();
    }

    @GetMapping("/{coursId}")
    public List<LessonDTO> getLessonByCours(
            @PathVariable String coursId,
            @RequestBody CoursDTO coursDTO){

        List<Lesson> lessons = lessonService.
                findLessonsByCours(dtoMapper.fromCoursDTO(coursDTO));

        return lessons.stream().map(dtoMapper::fromLesson).toList();
    }

    @GetMapping("/lessonsByParcours")
    public List<LessonDTO> getLessonByParcours(@RequestBody ParcoursDTO parcoursDTO){
        List<Cours> coursList = coursService
                .findCoursByParcours(dtoMapper.fromParcoursDTO(parcoursDTO));
        List<Lesson> lessonList = new ArrayList<>();

        List<Lesson> collect = coursList.stream().flatMap(cours -> cours.getLessons().stream())
                .distinct()
                .collect(Collectors.toList());

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
    public void deleteLesson(@PathVariable String lessonId){
        Lesson lesson = lessonService.getLessonById(lessonId);

        lessonService.deleteLesson(lesson);
    }

}
