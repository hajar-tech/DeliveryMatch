package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.AnnonceTrajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceTrajetRepository extends JpaRepository<AnnonceTrajet, Long> {
}
