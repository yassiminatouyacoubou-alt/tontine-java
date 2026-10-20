package com.tontine;

import com.tontine.model.Membre;
import com.tontine.model.Tontine;
import com.tontine.service.CotisationService;
import com.tontine.service.MembreService;
import com.tontine.service.TontineService;

public class Main {
    public static void main(String[] args) {
        MembreService membreService = new MembreService();
        CotisationService cotisationService = new CotisationService();
        TontineService tontineService = new TontineService(cotisationService);

        Membre a = membreService.creer("Awa", "0100000001");
        Membre b = membreService.creer("Koffi", "0100000002");
        Membre c = membreService.creer("Fatou", "0100000003");

        Tontine t = tontineService.creer("Tontine Étudiants", 10000, 3);
        tontineService.ajouterMembre(t, a);
        tontineService.ajouterMembre(t, b);
        tontineService.ajouterMembre(t, c);

        cotisationService.enregistrer(a, t);
        cotisationService.enregistrer(b, t);
        System.out.println("En retard : " + cotisationService.membresEnRetard(t));

        cotisationService.enregistrer(c, t);
        System.out.println("Bénéficiaire : " + tontineService.beneficiaireDuTour(t));
        System.out.println("Cagnotte : " + tontineService.cloturerTour(t) + " FCFA");
        System.out.println(t);
    }
}