package com.deliveryMatch.backend.services.implementationServices;

import com.deliveryMatch.backend.dtos.DemandeTransportDto;
import com.deliveryMatch.backend.enums.StatusDemande;
import com.deliveryMatch.backend.enums.TypeColis;
import com.deliveryMatch.backend.modules.*;
import com.deliveryMatch.backend.repository.AnnonceTrajetRepository;
import com.deliveryMatch.backend.repository.DemandeRepository;
import com.deliveryMatch.backend.repository.UserRepository;
import com.deliveryMatch.backend.services.InterfaceServices.DemandeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeImpl implements DemandeService {


    private final DemandeRepository demandeRepo;
    private final UserRepository expediteurRepo;
    private final AnnonceTrajetRepository annonceRepo;

    public DemandeImpl(
           DemandeRepository demandeRepo,
            UserRepository expediteurRepo,
            AnnonceTrajetRepository annonceRepo) {
        this.demandeRepo = demandeRepo;
        this.expediteurRepo = expediteurRepo;
        this.annonceRepo = annonceRepo;
    }

    @Override
    public DemandeTransportDto  creerDemande(DemandeTransportDto dto) {


        Expediteur expediteur = (Expediteur) expediteurRepo.findById(dto.expediteurId())
                .orElseThrow(() -> new RuntimeException("Expéditeur introuvable"));

        AnnonceTrajet annonce = annonceRepo.findById(dto.annonceId())
                .orElseThrow(() -> new RuntimeException("Annonce introuvable"));

        DemandeTransport demande = new DemandeTransport();
        demande.setLieuDepart(dto.lieuDepart());
        demande.setDestinationFinale(dto.destinationFinale());
        demande.setStatus(StatusDemande.valueOf(dto.status()));
        demande.setExpediteur(expediteur);
        demande.setAnnonce(annonce);

        // Conversion manuelle des colis
        List<Colis> colisList = dto.colis().stream().map(c -> {
            Colis colis = new Colis();
            colis.setPoidsColis(c.poidsColis());
            colis.setLongueurColis(c.longueurColis());
            colis.setHauteur(c.hauteur());
            colis.setType(TypeColis.valueOf(String.valueOf(c.type())));
            return colis;
        }).toList();
        demande.setColis(colisList);

        DemandeTransport saved = demandeRepo.save(demande);

        return new DemandeTransportDto(
                saved.getId(),
                saved.getLieuDepart(),
                saved.getDestinationFinale(),
                saved.getStatus().toString(),
                saved.getExpediteur().getId(),
                saved.getAnnonce().getId(),
                dto.colis() // on renvoie la même liste (peut être ajusté)
        );


    }
}
