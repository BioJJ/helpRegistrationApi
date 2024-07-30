package com.biojj.helpregistration.repositories;

import com.biojj.helpregistration.domain.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {

}
