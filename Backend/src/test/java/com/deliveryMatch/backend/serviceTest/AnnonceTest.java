package com.deliveryMatch.backend.serviceTest;

import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.modules.Conducteur;
import com.deliveryMatch.backend.repository.AnnonceTrajetRepository;
import com.deliveryMatch.backend.repository.UserRepository;
import com.deliveryMatch.backend.services.implementationServices.AnnonceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnnonceTest {

    @Mock
    private AnnonceTrajetRepository annonceTrajetRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AnnonceImpl annonceImpl;

    //test pour creer un annonce
    @Test
    void creerAnnonceTrajetTest() {
        Long conducteurId = 1L;
        Conducteur conducteur = new Conducteur();
        conducteur.setId(conducteurId);

        AnnonceTrajetDto dto = new AnnonceTrajetDto(
                conducteurId,
                "Tanger",
                Collections.singletonList("Benguerir , Settat"),
        "Casablanca",
                 "fragile",
                "100x80x50 cm",
                 130.0,
                 new Date(),
                new Date()
        );

        when(userRepository.findById(conducteurId)).thenReturn(Optional.of(conducteur));

        AnnonceTrajetDto result = annonceImpl.creerAnnonce(dto);

        assertEquals(dto.lieuDepart(), result.lieuDepart());
    }


    //test d'affichage  annonces
    @Test
    void getAnnonceTrajetTest() {
        // Création du conducteur mock
        Conducteur conducteur = new Conducteur();
        conducteur.setId(1L);

        // Annonce 1
        AnnonceTrajet annonce1 = new AnnonceTrajet();
        annonce1.setLieuDepart("Rabat");
        annonce1.setEtapeIntermediaire(Collections.singletonList("Casablanca"));
        annonce1.setDestinationFinale("Tanger");
        annonce1.setTypeMarchandise("Électronique");
        annonce1.setDimensionMaximales("100x50x50");
        annonce1.setCapaciteDisponible(50.0);
        annonce1.setDateDepart(new Date());
        annonce1.setDateAnance(new Date());
        annonce1.setConducteur(conducteur);

        // Annonce 2
        AnnonceTrajet annonce2 = new AnnonceTrajet();
        annonce2.setLieuDepart("Marrakech");
        annonce2.setEtapeIntermediaire(Collections.singletonList("Beni Mellal"));
        annonce2.setDestinationFinale("Fès");
        annonce2.setTypeMarchandise("Vêtements");
        annonce2.setDimensionMaximales("80x40x40");
        annonce2.setCapaciteDisponible(70.0);
        annonce2.setDateDepart(new Date());
        annonce2.setDateAnance(new Date());
        annonce2.setConducteur(conducteur);

        // Liste d'annonces simulée
        List<AnnonceTrajet> annonceTrajets = Arrays.asList(annonce1, annonce2);


        when(annonceTrajetRepository.findAll()).thenReturn(annonceTrajets);


        List<AnnonceTrajetDto> annonces = annonceImpl.getAllAnnonceTrajet();

        // Vérification
        assertEquals(2, annonces.size());
        assertEquals("Rabat", annonces.get(0).lieuDepart());
        assertEquals("Marrakech", annonces.get(1).lieuDepart());
    }




}
