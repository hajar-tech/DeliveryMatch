package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    Conducteur findByEmail(String email);
}
