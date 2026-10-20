package com.tontine.service;

import com.tontine.model.Membre;
import com.tontine.model.Tontine;
import java.util.ArrayList;
import java.util.List;

public class TontineService {
    private final List<Tontine> tontines = new ArrayList<>();
    private final CotisationService cotisationService;
    private int compteur = 1;

    public TontineService(CotisationService cotisationService) {
        this.cotisationService = cotisationService;
    }

    public Tontine creer(String nom, double montant, int capaciteMax) {
        if (montant <= 0 || capaciteMax < 2) {
            throw new IllegalArgumentException("Montant > 0 et au moins 2 membres requis.");
        }
        Tontine t = new Tontine(compteur++, nom, montant, capaciteMax);
        tontines.add(t);
        return t;
    }

    public void ajouterMembre(Tontine tontine, Membre membre) {
        if (tontine.getMembres().size() >= tontine.getCapaciteMax()) {
            throw new IllegalStateException("La tontine est complète.");
        }
        if (tontine.getMembres().contains(membre)) {
            throw new IllegalArgumentException("Membre déjà inscrit.");
        }
        tontine.getMembres().add(membre);
    }

    /** Le bénéficiaire du tour n est le n-ième membre inscrit. */
    public Membre beneficiaireDuTour(Tontine tontine) {
        return tontine.getMembres().get(tontine.getTourActuel() - 1);
    }

    /** Clôture le tour si tout le monde a cotisé et retourne la cagnotte versée. */
    public double cloturerTour(Tontine tontine) {
        if (!cotisationService.tourComplet(tontine)) {
            throw new IllegalStateException("Tour incomplet : des membres n'ont pas cotisé.");
        }
        double cagnotte = cotisationService.totalCollecte(tontine, tontine.getTourActuel());
        if (tontine.getTourActuel() < tontine.getMembres().size()) {
            tontine.setTourActuel(tontine.getTourActuel() + 1);
        }
        return cagnotte;
    }

    public List<Tontine> lister() { return new ArrayList<>(tontines); }
}