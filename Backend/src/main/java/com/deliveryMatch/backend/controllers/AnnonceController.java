package com.deliveryMatch.backend.controllers;

import com.deliveryMatch.backend.dtos.AnnonceTrajetDto;
import com.deliveryMatch.backend.modules.AnnonceTrajet;
import com.deliveryMatch.backend.services.implementationServices.AnnonceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    private final AnnonceImpl annonceService;
    public AnnonceController(AnnonceImpl annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping("/creer")
    public ResponseEntity <AnnonceTrajetDto> creerAnnonce (@RequestBody AnnonceTrajetDto annonceDto) {
       AnnonceTrajetDto annonceTrajet =  annonceService.creerAnnonce(annonceDto);
         return ResponseEntity.ok(annonceTrajet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnonceTrajetDto> modifierAnnonceTrajet (@PathVariable Long id, @RequestBody AnnonceTrajetDto annonceDto) {
        AnnonceTrajetDto annonceTrajetDto = annonceService.modifierAnnonceTrajet(annonceDto , id);
        return ResponseEntity.ok(annonceTrajetDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnonceTrajetDto> getAnnonceTrajet (@PathVariable Long id) {
        return ResponseEntity.ok(annonceService.getAnnonceTrajetById(id)) ;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnnonceTrajetDto>> getAllAnnonceTrajet() {
        return ResponseEntity.ok(annonceService.getAllAnnonceTrajet());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  supprimerAnnonceTrajet (@PathVariable Long id) {
        annonceService.deleteAnnonceTrajet(id) ;
              return ResponseEntity.noContent().build();

    }
}
