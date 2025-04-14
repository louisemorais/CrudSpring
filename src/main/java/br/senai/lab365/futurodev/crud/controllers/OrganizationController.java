package br.senai.lab365.futurodev.crud.controllers;

import br.senai.lab365.futurodev.crud.dtos.RequestProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseOrganizationDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResquestOrganizationDto;
import br.senai.lab365.futurodev.crud.models.Organization;
import br.senai.lab365.futurodev.crud.models.Project;
import br.senai.lab365.futurodev.crud.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @GetMapping
    public ResponseEntity<List<ResponseOrganizationDto>> getAll(String name){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOrganizationDto> getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOrganizationDto>post(@RequestBody ResquestOrganizationDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPost(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseOrganizationDto>updateById(@PathVariable(value = "id") Long id, @RequestBody ResquestOrganizationDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByid(@PathVariable(value = "id") Long id){
        //Map<String, String> response = new HashMap<>();
        try {
            service.deleteById(id);
            //response.put("mensagem", "Deletado com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
        }catch (Exception e){
            //response.put("mensagem", "id não encontrado! erro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id não encontrado! erro: " + e.getMessage());
        }
    }
}
