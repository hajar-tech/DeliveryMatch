package com.deliveryMatch.backend.dtos;

import com.deliveryMatch.backend.enums.TypeColis;

public record ColisDto (

        Double poidsColis,
        Double longueurColis,
        Double hauteur,
        String type
    ) {}



