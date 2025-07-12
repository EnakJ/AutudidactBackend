package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.ProgrammeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProgramController {
    private final ProgrammeService programmeService;
    private final DtoMapper dtoMapper;

    public ProgramController(ProgrammeService programmeService, DtoMapper dtoMapper){
        this.programmeService = programmeService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/programs")
    public Page<Programme> getPrograms(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ){
        return programmeService.findAllPrograms(page, size);
    }

    @GetMapping("/programs/{programId}")
    public Programme getProgramByid(@PathVariable String programId){
        return programmeService.getProgramById(programId);
    }

    @GetMapping("/programs/{matricule}")
    public Programme getProgramByMatricule(@PathVariable String matricule){
        return programmeService.getProgramByMatricule(matricule);
    }

    @GetMapping("/programs/{motCle}/programParMotCle")
    public Page<Programme> findProgramsByMotCle(
            @PathVariable String motCle,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){

        return programmeService.findProgramByMotCle(motCle, page, size);
    }

    @PostMapping("/programs")
    public ProgrammeDTO saveProgram(@RequestBody ProgrammeDTO programmeDTO){
        Programme programme = programmeService.saveProgram(dtoMapper.fromProgramDTO(programmeDTO));
        return dtoMapper.fromProgram(programme);
    }

    @PutMapping("/programs/{programId}")
    public ProgrammeDTO updateProgram(@PathVariable String programId , @RequestBody ProgrammeDTO programmeDTO){
        Programme programme = dtoMapper.fromProgramDTO(programmeDTO);
        return dtoMapper.fromProgram(programmeService.updateProgram(programme));
    }

    @DeleteMapping("/programs/{programId}")
    public void deleteProgram(@PathVariable String programId){
        programmeService.deleteProgram(programId);
    }
}
