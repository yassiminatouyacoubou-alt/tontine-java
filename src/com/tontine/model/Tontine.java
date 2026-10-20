package com.tontine.model;

import java.util.ArrayList;
import java.util.List;

public class Tontine {
    private final int id;
    private String nom;
    private double montantCotisation;
    private int capaciteMax;
    private int tourActuel = 1;
    private final List<Membre> membres = new ArrayList<>();

    public Tontine(int id, String nom, double montantCotisation, int capaciteMax) {
        this.id = id;
        this.nom = nom;
        this.montantCotisation = montantCotisation;
        this.capaciteMax = capaciteMax;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getMontantCotisation() { return montantCotisation; }
    public int getCapaciteMax() { return capaciteMax; }
    public int getTourActuel() { return tourActuel; }
    public void setTourActuel(int tourActuel) { this.tourActuel = tourActuel; }
    public List<Membre> getMembres() { return membres; }

    @Override
    public String toString() {
        return nom + " [tour " + tourActuel + ", " + membres.size() + "/" + capaciteMax + " membres]";
    }
}