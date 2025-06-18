package com.deliveryMatch.backend.dtos;

import java.util.List;

public record DemandeTransportDto (
        Long id,
        String lieuDepart,
        String destinationFinale,
        String status,
        Long expediteurId,
        Long annonceId,
        List<ColisDto> colis

){}

