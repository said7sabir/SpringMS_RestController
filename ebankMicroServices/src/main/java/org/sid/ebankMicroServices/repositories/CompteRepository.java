package org.sid.ebankMicroServices.repositories;

import org.sid.ebankMicroServices.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {
}
