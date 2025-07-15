package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.CoursDTO;
import com.autodidacte.autodidacteback.entities.Cours;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.CoursService;
import com.autodidacte.autodidacteback.services.ParcoursService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/cours")
public class CoursController {
    private final CoursService coursService;
    private final DtoMapper dtoMapper;
    private final ParcoursService parcoursService;


    public CoursController(CoursService coursService, DtoMapper dtoMapper, ParcoursService parcoursService){
        this.coursService = coursService;
        this.dtoMapper = dtoMapper;
        this.parcoursService = parcoursService;
    }

    @GetMapping("")
    public List<CoursDTO> getCours(){
        List<Cours> cours = coursService.findAllCours();

        return cours.stream().map(dtoMapper::fromCours).toList();
    }

    @GetMapping("/{coursId}")
    public CoursDTO getCoursById(@PathVariable String coursId){

        return dtoMapper.fromCours(coursService.getCoursById(coursId));
    }

    @GetMapping("/{matricule}")
    public CoursDTO getCoursByMatricule(@PathVariable String matricule){
        Cours cours = coursService.getCoursByMatricule(matricule);

        return dtoMapper.fromCours(cours);
    }

    @GetMapping("/{motCle}")
    public List<CoursDTO> getCoursByMotCle(@PathVariable String motCle){
        List<Cours> cours = coursService.findCoursByMotCle(motCle);

        return cours.stream().map(
                dtoMapper::fromCours
        ).toList();
    }

    @GetMapping("/{parcoursId}")
    public List<CoursDTO> getCoursByParcours(@PathVariable String parcoursId){
        Parcours parcours = parcoursService.getParcoursById(parcoursId);
        List<Cours> cours = coursService.findCoursByParcours(parcours);

        return cours.stream().map(
                dtoMapper::fromCours
        ).toList();
    }

    @GetMapping("/programId/{programId}")
    public List<CoursDTO> getCoursByProgram(@PathVariable String programId){
        List<Parcours> parcoursByProgram = parcoursService.getParcoursByProgram(programId);
        List<Cours> collectCours = parcoursByProgram.stream().flatMap(parcours -> parcours.getCoursList().stream())
                .distinct()
                .collect(Collectors.toList());

        return collectCours.stream().map(dtoMapper::fromCours).toList();
    }

    @PostMapping("/save")
    public CoursDTO saveCours(@RequestBody CoursDTO coursDTO){
        Cours cours = dtoMapper.fromCoursDTO(coursDTO);
        Cours cours1 = coursService.saveCours(cours);

        return dtoMapper.fromCours(cours1);
    }

    @PutMapping("/update/{coursId}")
    public CoursDTO updateCours(@PathVariable String coursId, @RequestBody CoursDTO coursDTO){
        Cours cours = dtoMapper.fromCoursDTO(coursDTO);
        Cours cours1 = coursService.saveCours(cours);

        return dtoMapper.fromCours(cours1);
    }

    @DeleteMapping("/delete/{coursId}")
    public void deleteCours(@PathVariable String coursId){
        coursService.deleteCours(coursId);
    }


}
