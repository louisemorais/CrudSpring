package br.senai.lab365.futurodev.crud.services;

import br.senai.lab365.futurodev.crud.Mappers.OrganizationMapper;
import br.senai.lab365.futurodev.crud.Mappers.ProjectMapper;
import br.senai.lab365.futurodev.crud.dtos.RequestProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseOrganizationDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResquestOrganizationDto;
import br.senai.lab365.futurodev.crud.models.Organization;
import br.senai.lab365.futurodev.crud.models.Project;
import br.senai.lab365.futurodev.crud.repositories.OrganizationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> findAll(){return organizationRepository.findAll();}

    public ResponseOrganizationDto findById(Long id) throws ResponseStatusException {
        Optional<Organization> organizations= organizationRepository.findById(id);
        if(organizations.isPresent()) {
            Organization organization= organizations.get();
            return OrganizationMapper.toDto(organization);
        }if (organizations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O id "+id+" não foi encontrado.");
        }
        return null;
    }

    public ResponseOrganizationDto createPost (ResquestOrganizationDto dto){
        Organization organization = OrganizationMapper.toEntity(dto);
        organizationRepository.save(organization);
        return OrganizationMapper.toDto(organization);
    }

    public ResponseOrganizationDto update(Long id, ResquestOrganizationDto dto){
        Optional<Organization> organizations= organizationRepository.findById(id);
        if (organizations.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O "+id+" não foi encontrado.");
        }
        Organization allOrganization= organizations.get();
        OrganizationMapper.update(dto,allOrganization);
        return OrganizationMapper.toDto( organizationRepository.save(allOrganization));
    }

    public void deleteById(Long id){
        if (!organizationRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O id "+id+" não foi encontrado.");
        }
        organizationRepository.deleteById(id);
    }
}
