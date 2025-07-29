package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.ProgramParcoursDTO;
import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.ProgrammeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "programs")
public class ProgramController {
    private final ProgrammeService programmeService;
    private final DtoMapper dtoMapper;

    public ProgramController(ProgrammeService programmeService, DtoMapper dtoMapper){
        this.programmeService = programmeService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("")
    public List<ProgrammeDTO> getPrograms(){
        return programmeService.findAllPrograms();
    }

    @GetMapping("/{Id}")
    public ProgrammeDTO getProgramByid(@PathVariable String Id) throws ProgrammeNotFoundException{
        return programmeService.getProgramById(Id);
    }

    @GetMapping("/programParcoursParId/{idProgram}")
    public ProgramParcoursDTO getProgramParcoursById(@PathVariable String idProgram) throws ProgrammeNotFoundException{
        return programmeService.getProgramParcoursById(idProgram);
    }

    @GetMapping("/programsWithParcours")
    public List<ProgramParcoursDTO> getProgramsParcours(){
        return programmeService.getAllProgramsWithParcours();
    }

    @GetMapping("/{matricule}")
    public ProgrammeDTO getProgramByMatricule(@PathVariable String matricule) throws ProgrammeNotFoundException{
        return programmeService.getProgramByMatricule(matricule);
    }

    @GetMapping("/programParMotCle/{motCle}")
    public List<ProgramParcoursDTO> findProgramsByMotCle(@PathVariable String motCle){
        return programmeService.findProgramByMotCle(motCle);

    }

    @PostMapping("/save")
    public ProgrammeDTO saveProgram(@RequestBody ProgrammeDTO programmeDTO){
        return programmeService
                .saveProgram(dtoMapper.fromProgramDTO(programmeDTO));
    }

    @PutMapping("/update/{programId}")
    public ProgramParcoursDTO updateProgram(
            @PathVariable String programId ,
            @RequestBody ProgramParcoursDTO programParcoursDTO)
    {
        Programme programme = dtoMapper.fromProgramParcoursDTO(programParcoursDTO);
        return programmeService.updateProgram(programme);
    }

    @DeleteMapping("/delete/{programId}")
    public ResponseEntity<Void> deleteProgram(@PathVariable String programId) throws ProgrammeNotFoundException {
        programmeService.deleteProgram(programId);

        return ResponseEntity.noContent().build();
    }
}
