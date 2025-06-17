package com.deliveryMatch.backend.modules;

import com.deliveryMatch.backend.enums.TypeColis;
import jakarta.persistence.*;

@Entity
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double poidsColis;
    private Double longueurColis;
    private Double hauteur;

    @Enumerated(EnumType.STRING)
    private TypeColis type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPoidsColis() {
        return poidsColis;
    }

    public void setPoidsColis(Double poidsColis) {
        this.poidsColis = poidsColis;
    }

    public Double getLongueurColis() {
        return longueurColis;
    }

    public void setLongueurColis(Double longueurColis) {
        this.longueurColis = longueurColis;
    }

    public Double getHauteur() {
        return hauteur;
    }

    public void setHauteur(Double hauteur) {
        this.hauteur = hauteur;
    }

    public TypeColis getType() {
        return type;
    }

    public void setType(TypeColis type) {
        this.type = type;
    }
}
