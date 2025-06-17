package com.deliveryMatch.backend.modules;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("Expediteur")
public class Expediteur extends Utilisateur {

    // Un expéditeur peut envoyer plusieurs demandes de transport
    @OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL)
    private List<DemandeTransport> demandes;

    public List<DemandeTransport> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<DemandeTransport> demandes) {
        this.demandes = demandes;
    }
}
