package br.senai.lab365.futurodev.crud.Mappers;

import br.senai.lab365.futurodev.crud.dtos.RequestProjectDto;
import br.senai.lab365.futurodev.crud.dtos.ResponseProjectDto;
import br.senai.lab365.futurodev.crud.models.Project;

public class ProjectMapper {

    private ProjectMapper(){}


    public static Project toEntity(RequestProjectDto dto){
        Project project = new Project();
        project.setName(dto.name());
        project.setDescription(dto.description());
        project.setRegion(dto.region());
        project.setCO2_Reduction_Estimate(dto.cO2_Reduction_Estimate());
        project.setOrganization(dto.organization());

        return project;
    }

    public static ResponseProjectDto toDto(Project ResponseProjectDto){

        return new ResponseProjectDto(  ResponseProjectDto.getId(), ResponseProjectDto.getName(),
                                        ResponseProjectDto.getDescription(), ResponseProjectDto.getRegion(),
                                        ResponseProjectDto.getCO2_Reduction_Estimate(), ResponseProjectDto.getOrganization());
    }

    public static ResponseProjectDto updateDto(RequestProjectDto dto, Project project){
        project.setName(dto.name());
        project.setDescription(dto.description());
        project.setRegion(dto.region());
        project.setCO2_Reduction_Estimate(dto.cO2_Reduction_Estimate());
        project.setOrganization(dto.organization());
                return toDto(project);
    }
}
