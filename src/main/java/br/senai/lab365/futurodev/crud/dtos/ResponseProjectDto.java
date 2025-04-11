package br.senai.lab365.futurodev.crud.dtos;

import br.senai.lab365.futurodev.crud.models.Organization;

public record ResponseProjectDto(Long id,String name, String description, String region,
                                 double cO2_Reduction_Estimate, Organization organization) {
}
