package com.deliveryMatch.backend.dtos;

import java.util.Date;
import java.util.List;


public record AnnonceTrajetDto (Long conducteurId,
                                String lieuDepart,
                                List<String> etapeIntermediaire,
                                String destinationFinale,
                                 String typeMarchandise,
                                String  dimensionMaximales ,
                                Double capaciteDisponible,
                                Date dateDepart,
                                 Date dateAnance
                                ){}



