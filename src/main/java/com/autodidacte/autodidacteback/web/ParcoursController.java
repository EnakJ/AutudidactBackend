package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.ParcoursFormationDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.ParcoursNotFoundException;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.ParcoursService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "parcours")
public class ParcoursController {
    private final ParcoursService parcoursService;
    private final DtoMapper dtoMapper;
    @Value("${imgParcoursCover}")
    private String imageUrlParcoursPath;

    public ParcoursController(ParcoursService parcoursService, DtoMapper dtoMapper){
        this.parcoursService = parcoursService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("")
    public List<ParcoursDTO> getParcours(){
        return parcoursService.getAllParcours();
    }

    public List<ParcoursFormationDTO> getParcoursFormationDTOs(){
        return parcoursService.getParcoursFormation();
    }

    @GetMapping("/parcoursParId/{parcoursId}")
    public ParcoursDTO getParcoursById(@PathVariable String parcoursId) throws ParcoursNotFoundException{
        return parcoursService.getParcoursById(parcoursId);
    }

    @GetMapping("/{motCle}")
    public List<ParcoursDTO> getParcoursByMotCle(@PathVariable String motCle) throws ParcoursNotFoundException{
        return parcoursService.findByMotCle(motCle);

    }

    @GetMapping("programId/{programId}")
    public List<ParcoursDTO> getParcoursByProgram(@PathVariable String programId) throws ParcoursNotFoundException, ProgrammeNotFoundException {
        return parcoursService.getParcoursByProgram(programId);
    }

    @PostMapping("/save")
    public ParcoursDTO saveParcours(@RequestBody ParcoursDTO parcoursDTO){
        Parcours parcours = dtoMapper.fromParcoursDTO(parcoursDTO);

        return parcoursService.saveParcours(parcours);
    }

    @PutMapping("/update/{parcoursId}")
    public ParcoursDTO updateParcours(@PathVariable String parcoursId,
                                      @RequestBody ParcoursDTO parcoursDTO)
    {
        Parcours parcours = parcoursService.updateParcours(
                dtoMapper.fromParcoursDTO(parcoursDTO)
        );

        return dtoMapper.fromParcours(parcours);
    }

    @DeleteMapping("/delete/{parcoursId}")
    public ResponseEntity<Void> deleteParcours(@PathVariable String parcoursId) throws ParcoursNotFoundException {
        parcoursService.deleteParcours(parcoursId);

        return ResponseEntity.noContent().build();
    }

}
