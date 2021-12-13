package com.khalil.sqlite;

public class Product {
    Integer id ;
    String nom;
    Integer quantite ;

    public Product() {
    }

    public Product(Integer id, String nom, Integer quantite) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
}
