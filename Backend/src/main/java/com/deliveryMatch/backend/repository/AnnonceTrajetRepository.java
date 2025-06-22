package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.modules.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface AnnonceTrajetRepository extends JpaRepository<AnnonceTrajet, Long> {
    List<AnnonceTrajet> findByConducteur(Conducteur conducteur);

    @Query("SELECT at FROM AnnonceTrajet at WHERE " +
            "(:destination IS NULL OR at.destinationFinale = :destination) AND " +
            "(:dateDepart IS NULL OR at.dateDepart = :dateDepart) AND " +
            "(:typeMarchandise IS NULL OR at.typeMarchandise = :typeMarchandise)")
    List<AnnonceTrajet> rechercherAnnoncesDisponibles(
            @Param("destination") String destination,
            @Param("dateDepart") Date dateDepart,
            @Param("typeMarchandise") String typeMarchandise
    );

    List<AnnonceTrajet> findByConducteurId(Long conducteurId);



}
