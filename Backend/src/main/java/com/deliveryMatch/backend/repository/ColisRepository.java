package com.deliveryMatch.backend.repository;

import com.deliveryMatch.backend.modules.Colis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisRepository extends CrudRepository<Colis, Integer> {
}
