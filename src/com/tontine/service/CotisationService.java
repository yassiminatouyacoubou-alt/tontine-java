package com.tontine.service;

import com.tontine.model.Cotisation;
import com.tontine.model.Membre;
import com.tontine.model.Tontine;
import java.util.ArrayList;
import java.util.List;

public class CotisationService {
    private final List<Cotisation> cotisations = new ArrayList<>();
    private int compteur = 1;

    public Cotisation enregistrer(Membre membre, Tontine tontine) {
        if (!tontine.getMembres().contains(membre)) {
            throw new IllegalArgumentException(membre.getNom() + " n'appartient pas à cette tontine.");
        }
        if (aCotise(membre, tontine, tontine.getTourActuel())) {
            throw new IllegalStateException(membre.getNom() + " a déjà cotisé pour ce tour.");
        }
        Cotisation c = new Cotisation(compteur++, membre, tontine,
                tontine.getTourActuel(), tontine.getMontantCotisation());
        cotisations.add(c);
        return c;
    }

    public boolean aCotise(Membre membre, Tontine tontine, int tour) {
        return cotisations.stream().anyMatch(c ->
                c.getMembre().equals(membre) && c.getTontine().equals(tontine) && c.getTour() == tour);
    }

    public double totalCollecte(Tontine tontine, int tour) {
        return cotisations.stream()
                .filter(c -> c.getTontine().equals(tontine) && c.getTour() == tour)
                .mapToDouble(Cotisation::getMontant)
                .sum();
    }

    public List<Membre> membresEnRetard(Tontine tontine) {
        List<Membre> retard = new ArrayList<>();
        for (Membre m : tontine.getMembres()) {
            if (!aCotise(m, tontine, tontine.getTourActuel())) retard.add(m);
        }
        return retard;
    }

    public boolean tourComplet(Tontine tontine) {
        return membresEnRetard(tontine).isEmpty() && !tontine.getMembres().isEmpty();
    }
}