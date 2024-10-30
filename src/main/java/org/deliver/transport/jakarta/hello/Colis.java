package org.deliver.transport.jakarta.hello;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Colis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int poid;
    private float prix;
    private Long origineX;
    private Long origineY;
    private Long destinationX;
    private Long destinationY;
    private Long localisationX;
    private Long localisationY;
    private String etat;

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

    public Long getId() {
        return id;
    }

    public int getPoid() {
        return poid;
    }

    public float getPrix() {
        return prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public void setPrix(float value) {
        this.prix = value;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String toString() {
        return "Colis { id: "+getId()+
                ", poid: "+getPoid()+
                ", prix: "+ getPrix()+
                ", origine: ("+getOrigineX()+", "+getOrigineY()+
                "), destination: ("+getDestinationX()+", "+getDestinationY()+
                "), localisation: ("+getLocalisationX()+", "+getLocalisationY()+
                "), etat: "+getEtat()+"}";
    }
}
