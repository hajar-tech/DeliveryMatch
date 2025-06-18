package com.deliveryMatch.backend.services.InterfaceServices;

import com.deliveryMatch.backend.dtos.DemandeTransportDto;
import com.deliveryMatch.backend.modules.DemandeTransport;

public interface DemandeService {

    DemandeTransportDto  creerDemande(DemandeTransportDto dto);

}
