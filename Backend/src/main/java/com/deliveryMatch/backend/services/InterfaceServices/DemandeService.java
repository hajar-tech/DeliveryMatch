package com.deliveryMatch.backend.services.InterfaceServices;

import com.deliveryMatch.backend.dtos.DemandeTransportDto;
import com.deliveryMatch.backend.modules.DemandeTransport;

import java.util.List;

public interface DemandeService {

    DemandeTransportDto  creerDemande(DemandeTransportDto dto);

    List<DemandeTransportDto> afficherDemandesByExpediteur(Long idExpediteur);

}
