package br.senai.lab365.futurodev.crud.services;

import br.senai.lab365.futurodev.crud.dtos.ResponseOrganizationDto;
import br.senai.lab365.futurodev.crud.dtos.ResquestOrganizationDto;
import br.senai.lab365.futurodev.crud.models.Organization;
import br.senai.lab365.futurodev.crud.repositories.OrganizationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public ResponseEntity getAllOrganizations() {
        List<Organization> listorganizations = organizationRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listorganizations);
    }

    public ResponseEntity getOrganizationById(Long id) {
        Optional<Organization> idorganization = organizationRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(idorganization.get());
    }

    public ResponseEntity saveOrganization(ResquestOrganizationDto dto) {
        var organizationss = new Organization();
        BeanUtils.copyProperties(dto, organizationss, "id");
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationRepository.save(organizationss));
    }

    public ResponseEntity updateOrganization(Long id, ResponseOrganizationDto dto) {
        Optional<Organization> idorganization = organizationRepository.findById(id);
        var organizationput = idorganization.get();
        BeanUtils.copyProperties(dto, organizationput, "id");
        return ResponseEntity.status(HttpStatus.OK).body(organizationRepository.save(organizationput));
    }

    public ResponseEntity deleteOrganizationById(Long id) {
        Optional<Organization> idorganization = organizationRepository.findById(id);
        organizationRepository.delete(idorganization.get());
        return ResponseEntity.status(HttpStatus.OK).body("organization deleted! id: " + id);
    }
}
