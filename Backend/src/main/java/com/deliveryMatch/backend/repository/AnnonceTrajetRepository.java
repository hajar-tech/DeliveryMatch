package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.modules.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnnonceTrajetRepository extends JpaRepository<AnnonceTrajet, Long> {
    List<AnnonceTrajet> findByConducteur(Conducteur conducteur);

}
