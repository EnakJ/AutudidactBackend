package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.FormationDTO;
import com.autodidacte.autodidacteback.dtos.LessonDTO;
import com.autodidacte.autodidacteback.dtos.RessourceDTO;
import com.autodidacte.autodidacteback.entities.Lesson;
import com.autodidacte.autodidacteback.entities.Ressource;
import com.autodidacte.autodidacteback.exceptions.LessonNotFoundException;
import com.autodidacte.autodidacteback.exceptions.RessourceNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.LessonService;
import com.autodidacte.autodidacteback.services.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("ressource")
public class RessourceController {
    private final RessourceService ressourceService;
    private final LessonService lessonService;
    private final DtoMapper dtoMapper;

    public RessourceController(RessourceService ressourceService,
                               LessonService lessonService,
                               DtoMapper dtoMapper)
    {
        this.ressourceService = ressourceService;
        this.lessonService = lessonService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("")
    public List<RessourceDTO> getRessources(){
        List<Ressource> ressources = ressourceService.findAllRessources();

        return ressources.stream().map(dtoMapper::fromRessource).toList();
    }

    @GetMapping("/{ressourceId}")
    public RessourceDTO getRessourceById(@PathVariable String ressourceId) throws RessourceNotFoundException {
        Ressource ressource = ressourceService.getRessourceById(ressourceId);

        return dtoMapper.fromRessource(ressource);
    }

    @GetMapping("/ressourcceParMatricule/{matricule}")
    public RessourceDTO getRessourceByMatricule(@PathVariable String matricule) throws RessourceNotFoundException{
        Ressource ressource = ressourceService.getRessourceByMatricule(matricule);

        return dtoMapper.fromRessource(ressource);
    }

    @GetMapping("/ressourcesParLesson/{lessonId}")
    public List<RessourceDTO> getRessourceByLesson(@PathVariable String lessonId,
                                                   @RequestBody LessonDTO lessonDTO) throws LessonNotFoundException
    {
        List<Ressource> ressources = ressourceService
                .findRessourceByLesson(dtoMapper.fromLessonDTO(lessonDTO));

        return ressources.stream().map(dtoMapper::fromRessource).toList();
    }

    @GetMapping("/ressourcesParFormation/{formationId}")
    public List<RessourceDTO> getRessourceByFormation(@PathVariable String formationId, FormationDTO formationDTO){
        List<Lesson> lessonByFormation = dtoMapper.fromFormationDTO(formationDTO).getLessons();

        List<Ressource> ressources = lessonByFormation.stream()
                .flatMap(lesson -> lesson.getRessources().stream())
                .distinct()
                .toList();

        return ressources.stream().map(dtoMapper::fromRessource).toList();
    }

    @GetMapping("/ressourceParMotCle/{motCle}")
    public List<RessourceDTO> getRessourceByMotCle(@PathVariable String motCle) throws RessourceNotFoundException{
        List<Ressource> ressources = ressourceService.findByMotCle(motCle);

        return ressources.stream().map(dtoMapper::fromRessource).toList();
    }

    @PostMapping("/save")
    public RessourceDTO saveRessource(@RequestBody RessourceDTO ressourceDTO){
        Ressource ressource = ressourceService
                .saveRessource(dtoMapper.fromRessourceDTO(ressourceDTO));

        return dtoMapper.fromRessource(ressource);
    }

    @PutMapping("/updateRessource/{ressourceId}")
    public RessourceDTO updateRessource(@PathVariable String ressourceId, @RequestBody RessourceDTO ressourceDTO){
        Ressource ressource = ressourceService
                .updateRessource(dtoMapper.fromRessourceDTO(ressourceDTO));

        return dtoMapper.fromRessource(ressource);
    }

    @DeleteMapping("/deleteRessource/{ressourceId}")
    public void deleteRessource(@PathVariable String ressourceId) throws RessourceNotFoundException{

        ressourceService.deleteRessource(ressourceId);
    }

}
