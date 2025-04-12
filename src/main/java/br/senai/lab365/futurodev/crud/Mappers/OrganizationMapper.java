package br.senai.lab365.futurodev.crud.Mappers;

import br.senai.lab365.futurodev.crud.dtos.ResponseOrganizationDto;
import br.senai.lab365.futurodev.crud.dtos.ResquestOrganizationDto;
import br.senai.lab365.futurodev.crud.models.Organization;

public class OrganizationMapper {
    private OrganizationMapper(){}

    public static Organization toEntity(ResquestOrganizationDto dto){
        Organization organization = new Organization();
        organization.setName(dto.name());
        organization.setContact(dto.contact());
        return organization;
    }

    public static ResponseOrganizationDto toDto(Organization ResponseOrganizationDto){
        return new ResponseOrganizationDto(ResponseOrganizationDto.getId(),
                ResponseOrganizationDto.getName(), ResponseOrganizationDto.getContact());
    }

    public static ResponseOrganizationDto update(ResquestOrganizationDto dto, Organization organization){
        organization.setName(dto.name());
        organization.setContact(dto.contact());
        return toDto(organization);
    }
}
