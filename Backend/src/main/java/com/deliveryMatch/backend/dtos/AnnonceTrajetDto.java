package com.deliveryMatch.backend.dtos;

import java.util.Date;
import java.util.List;


public record AnnonceTrajetDto (Long conducteurId,
                                String lieuDepart,
                                String destinationFinale,
                                List<String> etapeIntermediaire,
                                Date dateDepart,
                                Date dateAnance){}



