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

import java.util.List;

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
    public ResponseEntity<String> deleteByid(@PathVariable(value = "id") Long id){
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Id deletado com sucesso!");

    }
}
