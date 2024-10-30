package org.deliver.transport.jakarta.hello;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class ColisHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long colisId;
    private int poid;
    private float prix;
    private Long origineX;
    private Long origineY;
    private Long destinationX;
    private Long destinationY;
    private Long localisationX;
    private Long localisationY;
    private String etat;

    private LocalDateTime modifiedAt;

    public ColisHistory(Colis colis) {
        this.colisId = colis.getId();
        this.poid = colis.getPoid();
        this.prix = colis.getPrix();
        this.origineX = colis.getOrigineX();
        this.origineY = colis.getOrigineY();
        this.destinationX = colis.getDestinationX();
        this.destinationY = colis.getDestinationY();
        this.localisationX = colis.getLocalisationX();
        this.localisationY = colis.getLocalisationY();
        this.etat = colis.getEtat();
        this.modifiedAt = LocalDateTime.now();
    }

    // sert à rien
    public ColisHistory() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setColisId(Long colisId) {
        this.colisId = colisId;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setOrigineX(Long origineX) {
        this.origineX = origineX;
    }

    public void setOrigineY(Long origineY) {
        this.origineY = origineY;
    }

    public void setDestinationX(Long destinationX) {
        this.destinationX = destinationX;
    }

    public void setDestinationY(Long destinationY) {
        this.destinationY = destinationY;
    }

    public void setLocalisationX(Long localisationX) {
        this.localisationX = localisationX;
    }

    public void setLocalisationY(Long localisationY) {
        this.localisationY = localisationY;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getColisId() {
        return colisId;
    }

    public int getPoid() {
        return poid;
    }

    public float getPrix() {
        return prix;
    }

    public Long getOrigineX() {
        return origineX;
    }

    public Long getOrigineY() {
        return origineY;
    }

    public Long getDestinationX() {
        return destinationX;
    }

    public Long getDestinationY() {
        return destinationY;
    }

    public Long getLocalisationX() {
        return localisationX;
    }

    public Long getLocalisationY() {
        return localisationY;
    }

    public String getEtat() {
        return etat;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public String toString(){
        return "{ A: "+getModifiedAt()+", le colis n°"+getColisId()+" a été modifié. }";
    }
}
