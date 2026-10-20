package com.tontine.service;

import com.tontine.model.Membre;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MembreService {
    private final List<Membre> membres = new ArrayList<>();
    private int compteur = 1;

    public Membre creer(String nom, String telephone) {
        boolean existe = membres.stream().anyMatch(m -> m.getTelephone().equals(telephone));
        if (existe) {
            throw new IllegalArgumentException("Un membre avec ce téléphone existe déjà.");
        }
        Membre m = new Membre(compteur++, nom, telephone);
        membres.add(m);
        return m;
    }

    public Optional<Membre> trouverParId(int id) {
        return membres.stream().filter(m -> m.getId() == id).findFirst();
    }

    public List<Membre> lister() { return new ArrayList<>(membres); }

    public void supprimer(int id) { membres.removeIf(m -> m.getId() == id); }
}