package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.FormationDTO;
import com.autodidacte.autodidacteback.entities.Formation;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.FormationNotFoundExeption;
import com.autodidacte.autodidacteback.exceptions.ParcoursNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.FormationService;
import com.autodidacte.autodidacteback.services.ParcoursService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/formation")
public class FormationController {
    private final FormationService formationService;
    private final DtoMapper dtoMapper;
    private final ParcoursService parcoursService;


    public FormationController(
            FormationService formationService,
            DtoMapper dtoMapper,
            ParcoursService parcoursService)
    {
        this.formationService = formationService;
        this.dtoMapper = dtoMapper;
        this.parcoursService = parcoursService;
    }

    @GetMapping("")
    public List<FormationDTO> getFormations(){
        List<Formation> formations = formationService.findAllFormation();

        return formations.stream().map(dtoMapper::fromFormation).toList();
    }

    @GetMapping("/{formationId}")
    public FormationDTO getFormationById(@PathVariable String formationId) throws FormationNotFoundExeption {

        return dtoMapper.fromFormation(formationService.getFormationById(formationId));
    }

    @GetMapping("/{matricule}")
    public FormationDTO getFormationByMatricule(@PathVariable String matricule) throws FormationNotFoundExeption {
        Formation formation = formationService.getFormationByMatricule(matricule);

        return dtoMapper.fromFormation(formation);
    }

    @GetMapping("/{motCle}")
    public List<FormationDTO> getFormationByMotCle(@PathVariable String motCle) throws FormationNotFoundExeption {
        List<Formation> formations = formationService.findFormationByMotCle(motCle);

        return formations.stream().map(
                dtoMapper::fromFormation
        ).toList();
    }

    @GetMapping("/{parcoursId}")
    public List<FormationDTO> getFormationByParcours(@PathVariable String parcoursId) throws ParcoursNotFoundException {
        Parcours parcours = dtoMapper
                .fromParcoursDTO(parcoursService.getParcoursById(parcoursId));

        List<Formation> formations = formationService.findFormationByParcours(parcours);

        return formations.stream().map(
                dtoMapper::fromFormation
        ).toList();
    }

    @PostMapping("/save")
    public FormationDTO saveFormation(@RequestBody FormationDTO formationDTO){
        Formation formation = dtoMapper.fromFormationDTO(formationDTO);
        Formation formation1 = formationService.saveFormation(formation);

        return dtoMapper.fromFormation(formation1);
    }

    @PutMapping("/update/{formationId}")
    public FormationDTO updateFormation(@PathVariable String formationId, @RequestBody FormationDTO formationDTO){
        Formation formation = dtoMapper.fromFormationDTO(formationDTO);
        Formation formation1 = formationService.saveFormation(formation);

        return dtoMapper.fromFormation(formation1);
    }

    @DeleteMapping("/delete/{formationId}")
    public void deleteFormation(@PathVariable String formationId) throws FormationNotFoundExeption {
        formationService.deleteFormation(formationId);
    }


}
