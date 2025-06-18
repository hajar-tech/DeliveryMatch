package com.deliveryMatch.backend.controllers;

import com.deliveryMatch.backend.dtos.DemandeTransportDto;
import com.deliveryMatch.backend.modules.DemandeTransport;
import com.deliveryMatch.backend.services.implementationServices.DemandeImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
