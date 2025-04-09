package br.senai.lab365.futurodev.crud.repositories;

import br.senai.lab365.futurodev.crud.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
