package com.itsupport.backend.modules;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class AnnonceTrajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lieuDepart;
    private String destinationFinale;
    @ElementCollection
    private List<String> etapeIntermediaire;

    private Date dateAnance;
    private Date dateDepart;

    // L'annonce est publiée par un conducteur
    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    // Une annonce peut recevoir plusieurs demandes de transport
    @OneToMany(mappedBy = "annonce", cascade = CascadeType.ALL)
    private List<DemandeTransport> demandes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getEtapeIntermediaire() {
        return etapeIntermediaire;
    }

    public void setEtapeIntermediaire(List<String> etapeIntermediaire) {
        this.etapeIntermediaire = etapeIntermediaire;
    }

    public Date getDateAnance() {
        return dateAnance;
    }

    public void setDateAnance(Date dateAnance) {
        this.dateAnance = dateAnance;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public List<DemandeTransport> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<DemandeTransport> demandes) {
        this.demandes = demandes;
    }
}