package br.senai.lab365.futurodev.crud.controllers;

import br.senai.lab365.futurodev.crud.dtos.RequestProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseProjectDto;
import br.senai.lab365.futurodev.crud.models.Project;
import br.senai.lab365.futurodev.crud.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<Project>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProjectDto> getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseProjectDto>post(@RequestBody RequestProjectDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPost(dto));
    }

   @PutMapping("/{id}")
   public ResponseEntity<ResponseProjectDto>updateById(@PathVariable(value = "id") Long id, @RequestBody RequestProjectDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,dto));
   }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByid(@PathVariable(value = "id") Long id){
        Map<String, String> response = new HashMap<>();
        try {
            service.deleteById(id);
            response.put("mensagem", "Deletado com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            response.put("mensagem", "id não encontrado! erro: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
             }
    }
}
