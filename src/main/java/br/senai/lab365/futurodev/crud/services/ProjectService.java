package br.senai.lab365.futurodev.crud.services;

import br.senai.lab365.futurodev.crud.Mappers.ProjectMapper;
import br.senai.lab365.futurodev.crud.dtos.RequestProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseProjectDto;
import br.senai.lab365.futurodev.crud.models.Project;
import br.senai.lab365.futurodev.crud.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<ResponseProjectDto>findAll(String region){
        if(region==null || region.isEmpty()){
            return projectRepository.findAll().stream().map(project -> ProjectMapper.toDto(project)).toList();}
         else {
            return projectRepository.findByRegionContainingIgnoreCase(region).stream()
                                    .map(project -> ProjectMapper.toDto(project)).toList();
        }
    }

    public ResponseProjectDto findById(Long id){
        Optional<Project> projects= projectRepository.findById(id);
        if(projects.isPresent()) {
            return ProjectMapper.toDto(projects.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseProjectDto createPost (RequestProjectDto dto){
        Project project=ProjectMapper.toEntity(dto);
        projectRepository.save(project);
        return ProjectMapper.toDto(project);
    }

    public ResponseProjectDto update(Long id, RequestProjectDto dto){
        Optional<Project> projects= projectRepository.findById(id);
        if (projects.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Project allprojects= projects.get();
        ProjectMapper.updateDto(dto,allprojects);
        return ProjectMapper.toDto( projectRepository.save(allprojects));
    }

    public void deleteById(Long id){
        if (!projectRepository.existsById(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
        projectRepository.deleteById(id);
    }
}