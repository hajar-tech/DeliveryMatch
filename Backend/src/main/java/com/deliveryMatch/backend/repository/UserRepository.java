package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {
   Optional<Utilisateur> findByEmail(String email);
}
