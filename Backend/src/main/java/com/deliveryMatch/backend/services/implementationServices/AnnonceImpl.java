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
        AnnonceTrajet annonceTrajet = annonceRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("annonce introuvable !! "));

        return new AnnonceTrajetDto(
                annonceTrajet.getConducteur().getId(),
                annonceTrajet.getLieuDepart(),
                annonceTrajet.getEtapeIntermediaire(),
                annonceTrajet.getDestinationFinale(),
                annonceTrajet.getTypeMarchandise(),
                annonceTrajet.getDimensionMaximales(),
                annonceTrajet.getCapaciteDisponible(),
                annonceTrajet.getDateDepart(),
                annonceTrajet.getDateAnance()

        );
    }

    @Override
    public List<AnnonceTrajetDto> getAllAnnonceTrajet() {
        return annonceRepository.findAll().stream()
                .map(annonceTrajet -> new AnnonceTrajetDto(
                    annonceTrajet.getConducteur().getId(),
                    annonceTrajet.getLieuDepart(),
                    annonceTrajet.getEtapeIntermediaire(),
                    annonceTrajet.getDestinationFinale(),
                    annonceTrajet.getTypeMarchandise(),
                    annonceTrajet.getDimensionMaximales(),
                    annonceTrajet.getCapaciteDisponible(),
                    annonceTrajet.getDateDepart(),
                    annonceTrajet.getDateAnance()
                )).toList();
    }

    @Override
    public void deleteAnnonceTrajet(Long id) {
       if(!annonceRepository.existsById(id)) {
           throw new  RuntimeException("Annonce introuvable !! ");
       }
       annonceRepository.deleteById(id);

    }

    @Override
    public List<AnnonceTrajetDto> rechercherAnnonceTrajet(String destination, Date dateDepart, String typaMarchandise) {
        List<AnnonceTrajet> annonces = annonceRepository.rechercherAnnoncesDisponibles(destination, dateDepart, typaMarchandise);

        return annonces.stream().map(a -> new AnnonceTrajetDto(
                a.getConducteur().getId(),
                a.getLieuDepart(),
                a.getEtapeIntermediaire(),
                a.getDestinationFinale(),
                a.getTypeMarchandise(),
                a.getDimensionMaximales(),
                a.getCapaciteDisponible(),
                a.getDateDepart(),
                a.getDateAnance()
        )).toList();
    }


    public List<AnnonceTrajetDto> getAnnonceByConducteur(Long conducteurId) {
        return annonceRepository.findByConducteurId(conducteurId).stream()
                .map(annonce -> new AnnonceTrajetDto(
                        annonce.getConducteur().getId(),
                        annonce.getLieuDepart(),
                        annonce.getEtapeIntermediaire(),
                        annonce.getDestinationFinale(),
                        annonce.getTypeMarchandise(),
                        annonce.getDimensionMaximales(),
                        annonce.getCapaciteDisponible(),
                        annonce.getDateDepart(),
                        annonce.getDateAnance()
                ))
                .toList();
    }


}
