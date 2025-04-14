package br.senai.lab365.futurodev.crud.repositories;

import br.senai.lab365.futurodev.crud.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByNameContainingIgnoreCase(String name);
}
