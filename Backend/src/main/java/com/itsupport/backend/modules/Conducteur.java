package com.itsupport.backend.modules;


import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue("Conducteur")
public class Conducteur extends User{

    //un conducteur peut publier plusieurs annonces
    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<AnnonceTrajet> annonces;

    public List<AnnonceTrajet> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<AnnonceTrajet> annonces) {
        this.annonces = annonces;
    }
}
