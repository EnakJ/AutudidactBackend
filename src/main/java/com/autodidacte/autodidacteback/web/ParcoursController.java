package com.autodidacte.autodidacteback.web;

import com.autodidacte.autodidacteback.dtos.ParcoursFormationDTO;
import com.autodidacte.autodidacteback.dtos.ParcoursDTO;
import com.autodidacte.autodidacteback.dtos.ProgrammeDTO;
import com.autodidacte.autodidacteback.entities.Parcours;
import com.autodidacte.autodidacteback.exceptions.ParcoursNotFoundException;
import com.autodidacte.autodidacteback.exceptions.ProgrammeNotFoundException;
import com.autodidacte.autodidacteback.mappers.DtoMapper;
import com.autodidacte.autodidacteback.services.ParcoursService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

    @GetMapping("/parcoursWithFormations")
    public List<ParcoursFormationDTO> getParcoursFormationDTOs(){
        return parcoursService.getParcoursFormation();
    }

    @GetMapping("/{parcoursId}/parcour")
    public ParcoursDTO getParcoursById(@PathVariable String parcoursId) throws ParcoursNotFoundException{
        return parcoursService.getParcoursById(parcoursId);
    }

    @GetMapping("/{motCle}/parcour")
    public List<ParcoursDTO> getParcoursByMotCle(@PathVariable String motCle) throws ParcoursNotFoundException{
        return parcoursService.findByMotCle(motCle);

    }

    @GetMapping("programId/{programId}/parcours")
    public List<ParcoursDTO> getParcoursByProgram(@PathVariable String programId) throws ParcoursNotFoundException, ProgrammeNotFoundException {
        return parcoursService.getParcoursByProgram(programId);
    }

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ParcoursDTO saveParcours(
            @RequestBody ParcoursDTO parcoursDTO,
            @RequestParam("picture") MultipartFile image) throws IOException {
        Parcours parcours = dtoMapper.fromParcoursDTO(parcoursDTO);
        if(!image.isEmpty()){
            parcoursDTO.setImageUrl(image.getOriginalFilename());
            image.transferTo(new File(imageUrlParcoursPath + "" + parcoursDTO.getImageUrl()));
        }

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


    @GetMapping(value = "/{parcoursId}/image")
    public ResponseEntity<byte[]> getParcoursImage(@PathVariable String parcoursId) throws ParcoursNotFoundException, IOException {
        ParcoursDTO parcours = parcoursService.getParcoursById(parcoursId);

        File imageFile = new File(imageUrlParcoursPath + "" + parcours.getImageUrl());

        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        String mimeType = Files.probeContentType(imageFile.toPath());
        MediaType mediaType = MediaType.parseMediaType(mimeType);

        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(imageBytes);
    }

}
