package com.deliveryMatch.backend.dtos;

import java.util.Date;
import java.util.List;


public class AnnonceTrajetDto {
    private Long conducteurId;
    private String lieuDepart;
    private String destinationFinale;
    private List<String> etapeIntermediaire;
    private Date dateDepart;
    private Date dateAnance;

    public Date getDateAnance() {
        return dateAnance;
    }

    public void setDateAnance(Date dateAnance) {
        this.dateAnance = dateAnance;
    }

    public Long getConducteurId() {
        return conducteurId;
    }

    public void setConducteurId(Long conducteurId) {
        this.conducteurId = conducteurId;
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

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }
}
