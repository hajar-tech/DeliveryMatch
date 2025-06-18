package com.deliveryMatch.backend.dtos;

import java.util.List;

public record DemandeTransportDto (
        String lieuDepart,
        String destinationFinale,
        Long expediteurId,
        Long annonceId,
        List<ColisDto> colis

){}

