package com.tontine.model;

public class Membre {
    private final int id;
    private String nom;
    private String telephone;

    public Membre(int id, String nom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getTelephone() { return telephone; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Override
    public String toString() { return nom + " (" + telephone + ")"; }
}