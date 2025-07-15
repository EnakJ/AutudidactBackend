package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.ParcoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "parcours")
public class ParcoursController {
    private final ParcoursService parcoursService;
    private final DtoMapper dtoMapper;

    public ParcoursController(ParcoursService parcoursService, DtoMapper dtoMapper){
        this.parcoursService = parcoursService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("")
    public List<ParcoursDTO> getParcours(){
        List<Parcours> parcours = parcoursService.findAll();

        return parcours.stream().map(dtoMapper::fromParcours).toList();
    }

    @GetMapping("/parcoursParId/{parcoursId}")
    public ParcoursDTO getParcoursById(@PathVariable String parcoursId){
        Parcours parcours = parcoursService.getParcoursById(parcoursId);

        return dtoMapper.fromParcours(parcours);
    }

    @GetMapping("/{motCle}")
    public List<ParcoursDTO> getParcoursByMotCle(@PathVariable String motCle){
        List<Parcours> parcours = parcoursService.findByMotCle(motCle);

        return parcours.stream().map(
                dtoMapper::fromParcours
        ).toList();

    }

    @GetMapping("programId/{programId}")
    public List<ParcoursDTO> getParcoursByProgram(@PathVariable String programId){
        List<Parcours> parcours = parcoursService.getParcoursByProgram(programId);

        return parcours.stream().map(dtoMapper::fromParcours).toList();
    }

    @PostMapping("/save")
    public ParcoursDTO saveParcours(@RequestBody ParcoursDTO parcoursDTO){
        Parcours parcours = dtoMapper.fromParcoursDTO(parcoursDTO);

        return dtoMapper.fromParcours(
                parcoursService.saveParcours(parcours)
        );
    }

    @PutMapping("/update/{parcoursId}")
    public ParcoursDTO updateParcours(@PathVariable String parcoursId,
                                      @RequestBody ParcoursDTO parcoursDTO)
    {
        Parcours parcours = parcoursService.saveParcours(
                dtoMapper.fromParcoursDTO(parcoursDTO)
        );

        return dtoMapper.fromParcours(parcours);
    }

    @DeleteMapping("/delete/{parcoursId}")
    public ResponseEntity<Void> deleteParcours(@PathVariable String parcoursId){
        parcoursService.deleteParcours(parcoursId);

        return ResponseEntity.noContent().build();
    }

}
