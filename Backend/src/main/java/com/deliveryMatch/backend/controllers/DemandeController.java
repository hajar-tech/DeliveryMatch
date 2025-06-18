package com.deliveryMatch.backend.controllers;

import com.deliveryMatch.backend.dtos.DemandeTransportDto;
import com.deliveryMatch.backend.modules.DemandeTransport;
import com.deliveryMatch.backend.services.implementationServices.DemandeImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandeTransports")
public class DemandeController {

    private final DemandeImpl demandeService;

    public DemandeController(DemandeImpl demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping("/creer")
    public ResponseEntity<DemandeTransportDto > creerDemande(@RequestBody DemandeTransportDto dto) {
        return ResponseEntity.ok(demandeService.creerDemande(dto));
    }

    @GetMapping("/expedieur/{id}")
    public ResponseEntity<List<DemandeTransportDto>>afficherDemandesTransportByExpedieur(@PathVariable Long id) {
        return ResponseEntity.ok(demandeService.afficherDemandesByExpediteur(id));
    }
}
