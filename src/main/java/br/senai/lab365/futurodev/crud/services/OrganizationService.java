package br.senai.lab365.futurodev.crud.services;

import br.senai.lab365.futurodev.crud.Mappers.OrganizationMapper;
import br.senai.lab365.futurodev.crud.dtos.ResponseOrganizationDto;
import br.senai.lab365.futurodev.crud.dtos.ResquestOrganizationDto;
import br.senai.lab365.futurodev.crud.models.Organization;
import br.senai.lab365.futurodev.crud.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<ResponseOrganizationDto> findAll(String name) {
        if (name == null || name.isEmpty()) {
            return organizationRepository.findAll().stream().map(organization ->
                                          OrganizationMapper.toDto(organization)).toList();
        } else {
            return organizationRepository.findByNameContainingIgnoreCase(name).stream()
                                         .map(organization -> OrganizationMapper.toDto(organization)).toList();
        }
    }

    public ResponseOrganizationDto findById(Long id){
        Optional<Organization> organizations= organizationRepository.findById(id);
        if(organizations.isPresent()) {
            Organization organization= organizations.get();
            return OrganizationMapper.toDto(organization);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        organizationRepository.deleteById(id);
    }
}
