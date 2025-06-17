package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.DemandeTransport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends CrudRepository<DemandeTransport, Long> {
}
