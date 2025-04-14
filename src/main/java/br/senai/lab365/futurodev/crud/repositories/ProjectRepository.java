package br.senai.lab365.futurodev.crud.repositories;

import br.senai.lab365.futurodev.crud.models.Organization;
import br.senai.lab365.futurodev.crud.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByRegionContainingIgnoreCase(String name);
}
