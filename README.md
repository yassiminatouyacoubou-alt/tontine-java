# Tontine numérique (Java)

Projet de modélisation objet d'une **tontine numérique** : des membres cotisent à chaque tour, et à chaque tour un membre différent reçoit la cagnotte.

## Entités (3)

| Entité | Rôle |
|---|---|
| `Membre` | Une personne (id, nom, téléphone) |
| `Tontine` | Le groupe (nom, montant de cotisation, capacité, tour actuel, liste des membres) |
| `Cotisation` | Un paiement d'un membre pour un tour d'une tontine |

**Relations :**
- Une `Tontine` contient plusieurs `Membre` (1 → *)
- Une `Cotisation` est liée à un `Membre` et à une `Tontine`

## Services (3)

- **`MembreService`** : créer (téléphone unique), trouver par id, lister, supprimer
- **`TontineService`** : créer, ajouter un membre, désigner le bénéficiaire du tour, clôturer le tour
- **`CotisationService`** : enregistrer une cotisation, vérifier si un membre a cotisé, total collecté, membres en retard, tour complet

## Structure

```
src/com/tontine/
├── Main.java
├── model/
│   ├── Membre.java
│   ├── Tontine.java
│   └── Cotisation.java
└── service/
    ├── MembreService.java
    ├── TontineService.java
    └── CotisationService.java
```

## Compilation et exécution

```bash
mkdir out
javac -encoding UTF-8 -d out src/com/tontine/Main.java src/com/tontine/model/*.java src/com/tontine/service/*.java
java -cp out com.tontine.Main
```

## Auteur

Yassiminatou