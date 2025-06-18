package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.DemandeTransport;
import com.deliveryMatch.backend.modules.Expediteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<DemandeTransport, Long> {
    List<DemandeTransport> getAllByExpediteur(Expediteur expediteur);
}
