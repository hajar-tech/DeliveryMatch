package com.deliveryMatch.backend.services.InterfaceServices;


import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.modules.AnnonceTrajet;

import java.util.List;

public interface AnnonceService {

     AnnonceTrajetDto creerAnnonce(AnnonceTrajetDto annonceTrajetDto);
     AnnonceTrajetDto modifierAnnonceTrajet(AnnonceTrajetDto annonceTrajetDto , Long id);
     AnnonceTrajetDto getAnnonceTrajetById(Long id);
     List<AnnonceTrajetDto> getAllAnnonceTrajet();
     void deleteAnnonceTrajet(Long id);
}
