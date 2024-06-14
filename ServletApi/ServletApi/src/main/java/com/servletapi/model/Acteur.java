package com.servletapi.model;


import jakarta.persistence.*;

// Model
@Entity
@Table(name="acteur")
public class Acteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String photo;

    public Acteur() {}

    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Acteur(String nom, String prenom, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }

    public Acteur(int id, String nom, String prenom, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }
    public int getId() {
        return this.id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getPhoto() {
        return photo;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
