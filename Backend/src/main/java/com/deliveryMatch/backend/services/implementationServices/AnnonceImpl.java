package com.deliveryMatch.backend.services.implementationServices;

import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;

import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.modules.Conducteur;

import com.deliveryMatch.backend.repository.AnnonceTrajetRepository;

import com.deliveryMatch.backend.repository.UserRepository;
import com.deliveryMatch.backend.services.InterfaceServices.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class AnnonceImpl implements AnnonceService {

  private   final AnnonceTrajetRepository annonceRepository;

   private final UserRepository userRepository;

   @Autowired
    public AnnonceImpl(UserRepository userRepository, AnnonceTrajetRepository annonceRepository) {
        this.annonceRepository = annonceRepository;

        this.userRepository = userRepository;
    }

    @Override
    public AnnonceTrajetDto creerAnnonce(AnnonceTrajetDto annonceTrajetDto) {

       //verifier que le conducteur exist
        Conducteur conducteur = (Conducteur) userRepository.findById(annonceTrajetDto.conducteurId())
                .orElseThrow(()-> new RuntimeException("Conducteur non trouvé !!"));

        //créer l'entité à partir du DTO
        AnnonceTrajet annonce = new AnnonceTrajet();
        annonce.setConducteur(conducteur);
        annonce.setTypeMarchandise(annonceTrajetDto.typeMarchandise());
        annonce.setDimensionMaximales(annonceTrajetDto.dimensionMaximales());
        annonce.setCapaciteDisponible(annonceTrajetDto.capaciteDisponible());
        annonce.setLieuDepart(annonceTrajetDto.lieuDepart());
        annonce.setEtapeIntermediaire(annonceTrajetDto.etapeIntermediaire());
        annonce.setDestinationFinale(annonceTrajetDto.destinationFinale());
        annonce.setDateAnance(annonceTrajetDto.dateAnance() != null ? annonceTrajetDto.dateAnance() : new Date());
        annonce.setDateDepart(annonceTrajetDto.dateDepart());

        //sauvegarder et retourner le résultat
        annonceRepository.save(annonce);
        return annonceTrajetDto;
    }

    //modifier un annonce de Trajet
    @Override
    public AnnonceTrajetDto modifierAnnonceTrajet(AnnonceTrajetDto annonceTrajetDto, Long id) {

      //vérifier si l'annonce existe ou non
        AnnonceTrajet annonceTrajet = annonceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("annonce introuvable !! "));

        //modifier les attribues
        annonceTrajet.setDateDepart(annonceTrajetDto.dateDepart());
        annonceTrajet.setCapaciteDisponible(annonceTrajetDto.capaciteDisponible());
        annonceTrajet.setDimensionMaximales(annonceTrajetDto.dimensionMaximales());
        annonceTrajet.setTypeMarchandise(annonceTrajetDto.typeMarchandise());
        annonceTrajet.setEtapeIntermediaire(annonceTrajetDto.etapeIntermediaire());
        annonceTrajet.setDestinationFinale(annonceTrajetDto.destinationFinale());
        annonceTrajet.setDateAnance(new Date());
        annonceTrajet.setLieuDepart(annonceTrajetDto.lieuDepart());

//        //vérifier si je veux vérifier
//        if (annonceTrajetDto.conducteurId() != null) {
//            Conducteur conducteur = (Conducteur) userRepository.findById(annonceTrajetDto.conducteurId())
//                    .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));
//            annonceTrajet.setConducteur(conducteur);
//        }
        annonceRepository.save(annonceTrajet);

      return annonceTrajetDto;
    }

    @Override
    public AnnonceTrajetDto getAnnonceTrajetById(Long id) {
        return null;
    }

    @Override
    public List<AnnonceTrajetDto> getAllAnnonceTrajet() {
        return List.of();
    }

    @Override
    public void deleteAnnonceTrajet(Long id) {

    }




}
