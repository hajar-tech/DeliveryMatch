package com.deliveryMatch.backend.services.InterfaceServices;


import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.modules.AnnonceTrajet;

public interface AnnonceService {

     AnnonceTrajetDto creerAnnonce(AnnonceTrajetDto annonceTrajetDto);
     AnnonceTrajet modifierAnnonceTrajet(AnnonceTrajetDto annonceTrajetDto , Long id);
}
