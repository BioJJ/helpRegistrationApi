package com.biojj.helpregistration.repositories;

import com.biojj.helpregistration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByCpf(String cpf);

    Optional<User> findByEmail(String email);
}
