package com.deliveryMatch.backend.modules;

import com.deliveryMatch.backend.enums.StatusDemande;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class DemandeTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusDemande status;

    private String lieuDepart;
    private String destinationFinale;

    // Expéditeur qui a créé la demande
    @ManyToOne
    @JoinColumn(name = "expediteur_id")
    private Expediteur expediteur;

    // L'annonce à laquelle la demande est liée
    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private AnnonceTrajet annonce;

    // Liste des colis à transporter pour cette demande
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "demande_id")
    private List<Colis> colis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusDemande getStatus() {
        return status;
    }

    public void setStatus(StatusDemande status) {
        this.status = status;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getDestinationFinale() {
        return destinationFinale;
    }

    public void setDestinationFinale(String destinationFinale) {
        this.destinationFinale = destinationFinale;
    }

    public Expediteur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Expediteur expediteur) {
        this.expediteur = expediteur;
    }

    public AnnonceTrajet getAnnonce() {
        return annonce;
    }

    public void setAnnonce(AnnonceTrajet annonce) {
        this.annonce = annonce;
    }

    public List<Colis> getColis() {
        return colis;
    }

    public void setColis(List<Colis> colis) {
        this.colis = colis;
    }
}
