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

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    //alterar o find all e ver formas melhores de fazer por enquanto seguir o professor
    public List<Project>findAll(){return projectRepository.findAll();}

    //ver formas melhores de fazer o find by id
    public ResponseProjectDto findById(Long id){
        Optional<Project> projects= projectRepository.findById(id);
        if(projects.isPresent()) {
            Project project = projects.get();
            return ProjectMapper.toDto(project);
        }
        return null;
    }

    //create post ta certo
    public ResponseProjectDto createPost (RequestProjectDto dto){
        Project project=ProjectMapper.toEntity(dto);
        projectRepository.save(project);
        return ProjectMapper.toDto(project);
    }

    public ResponseProjectDto update(Long id, RequestProjectDto dto){
        Optional<Project> projects= projectRepository.findById(id);
        if (projects.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O "+id+" não foi encontrado.");
        }
        Project allprojects= projects.get();
        ProjectMapper.updateDto(dto,allprojects);
        return ProjectMapper.toDto( projectRepository.save(allprojects));
    }

    //fazer validação
    public void deleteById(Long id){
        if (!projectRepository.existsById(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O id "+id+" não foi encontrado.");
       }
        projectRepository.deleteById(id);
    }
}