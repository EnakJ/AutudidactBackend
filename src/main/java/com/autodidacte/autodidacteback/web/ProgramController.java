package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Programme;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.ProgrammeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        List<Programme> programmes = programmeService.findAllPrograms();
        return programmes.stream().map(dtoMapper::fromProgram).toList();
    }

    @GetMapping("/{Id}")
    public ProgrammeDTO getProgramByid(@PathVariable String Id){
        return dtoMapper.fromProgram(programmeService.getProgramById(Id));
    }

    @GetMapping("/{matricule}")
    public ProgrammeDTO getProgramByMatricule(@PathVariable String matricule){
        return dtoMapper.fromProgram(
                programmeService.getProgramByMatricule(matricule)
        );
    }

    @GetMapping("/programParMotCle/{motCle}")
    public List<ProgrammeDTO> findProgramsByMotCle(@PathVariable String motCle){
        List<Programme> programmes = programmeService.findProgramByMotCle(motCle);

        return programmes.stream().map(dtoMapper::fromProgram).toList();
    }

    @PostMapping("/save")
    public ProgrammeDTO saveProgram(@RequestBody ProgrammeDTO programmeDTO){

        Programme programme = programmeService.saveProgram(dtoMapper.fromProgramDTO(programmeDTO));

        return dtoMapper.fromProgram(programme);
    }

    @PutMapping("/update/{programId}")
    public ProgrammeDTO updateProgram(@PathVariable String programId , @RequestBody ProgrammeDTO programmeDTO){
        Programme programme = dtoMapper.fromProgramDTO(programmeDTO);
        return dtoMapper.fromProgram(programmeService.updateProgram(programme));
    }

    @DeleteMapping("/delete/{programId}")
    public ResponseEntity<Void> deleteProgram(@PathVariable String programId){
        programmeService.deleteProgram(programId);

        return ResponseEntity.noContent().build();
    }
}
