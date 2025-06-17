package com.deliveryMatch.backend.controllers;

import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.services.implementationServices.AnnonceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    private final AnnonceImpl annonceService;
    public AnnonceController(AnnonceImpl annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping("/creer")
    public ResponseEntity <AnnonceTrajetDto> creerAnnonce (@RequestBody AnnonceTrajetDto annonceDto) {
       AnnonceTrajetDto annonceTrajet=  annonceService.creerAnnonce(annonceDto);
         return ResponseEntity.ok(annonceTrajet);
    }
}
