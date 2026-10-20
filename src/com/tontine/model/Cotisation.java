package com.tontine.model;

import java.time.LocalDate;

public class Cotisation {
    private final int id;
    private final Membre membre;
    private final Tontine tontine;
    private final int tour;
    private final double montant;
    private final LocalDate date;

    public Cotisation(int id, Membre membre, Tontine tontine, int tour, double montant) {
        this.id = id;
        this.membre = membre;
        this.tontine = tontine;
        this.tour = tour;
        this.montant = montant;
        this.date = LocalDate.now();
    }

    public int getId() { return id; }
    public Membre getMembre() { return membre; }
    public Tontine getTontine() { return tontine; }
    public int getTour() { return tour; }
    public double getMontant() { return montant; }
    public LocalDate getDate() { return date; }
}