package br.senai.lab365.futurodev.crud.controllers;

import br.senai.lab365.futurodev.crud.dtos.ResponseOrganizationDto;
import br.senai.lab365.futurodev.crud.dtos.ResquestOrganizationDto;
import br.senai.lab365.futurodev.crud.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    /// refazer um pouco o controller com a dto e métodos do response entity
    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public ResponseEntity getAll() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ResquestOrganizationDto dto) {
        return organizationService.saveOrganization(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody ResponseOrganizationDto dto) {
        return organizationService.updateOrganization(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        return organizationService.deleteOrganizationById(id);
    }
}
