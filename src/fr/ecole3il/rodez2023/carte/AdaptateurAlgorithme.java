package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe fournit des méthodes statiques pour adapter un algorithme de recherche de chemin à une carte.
 */
public class AdaptateurAlgorithme {

    /**
     * Trouve un chemin entre deux points sur une carte en utilisant un algorithme de recherche de chemin.
     *
     * @param algorithme L'algorithme de recherche de chemin.
     * @param carte      La carte sur laquelle rechercher le chemin.
     * @param xDepart    La coordonnée x du point de départ.
     * @param yDepart    La coordonnée y du point de départ.
     * @param xArrivee   La coordonnée x du point d'arrivée.
     * @param yArrivee   La coordonnée y du point d'arrivée.
     * @return Le chemin trouvé.
     */
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
        Graphe<Case> graphe = creerGraphe(carte);

        Tuile tuileDepart = carte.getTuile(xDepart, yDepart);
        Case depart = new Case(tuileDepart, xDepart, yDepart);

        Tuile tuileArrivee = carte.getTuile(xArrivee, yArrivee);
        Case arrivee = new Case(tuileArrivee, xArrivee, yArrivee);

        List<Noeud<Case>> chemin = algorithme.trouverChemin(graphe, new Noeud<>(depart), new Noeud<>(arrivee));

        return afficherChemin(chemin);
    }

    /**
     * Crée un graphe à partir d'une carte.
     *
     * @param carte La carte à partir de laquelle créer le graphe.
     * @return Le graphe créé.
     */
    static Graphe<Case> creerGraphe(Carte carte) {
        Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();

        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Tuile tuileCourante = carte.getTuile(x, y);
                Case caseCourante = new Case(tuileCourante, x, y);
                graphe.ajouterNoeud(new Noeud<>(caseCourante));
                ajouterAretesVoisines(graphe, caseCourante, x, y, largeur, hauteur);
            }
        }

        return graphe;
    }

    /**
     * Ajoute des arêtes aux noeuds voisins dans le graphe.
     *
     * @param graphe  Le graphe auquel ajouter les arêtes.
     * @param currentCase  La case actuelle.
     * @param x       La coordonnée x de la case actuelle.
     * @param y       La coordonnée y de la case actuelle.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     */
    static void ajouterAretesVoisines(Graphe<Case> graphe, Case currentCase, int x, int y, int largeur, int hauteur) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < largeur && newY >= 0 && newY < hauteur) {
                    Case voisin = new Case(currentCase.getTuile(), newX, newY);
                    graphe.ajouterArete(new Noeud<>(currentCase), new Noeud<>(voisin), calculerCout(currentCase, voisin));
                }
            }
        }
    }

    /**
     * Calcule le coût entre deux cases.
     *
     * @param from La case de départ.
     * @param to   La case d'arrivée.
     * @return Le coût entre les deux cases.
     */
    static double calculerCout(Case from, Case to) {
        if (from == null || to == null)
            return Double.POSITIVE_INFINITY;

        return 1.0;
    }

    /**
     * Affiche le chemin trouvé.
     *
     * @param chemin Le chemin trouvé.
     * @return Le chemin trouvé sous forme d'objet Chemin.
     */
    static Chemin afficherChemin(List<Noeud<Case>> chemin) {
        if (chemin.isEmpty()) {
            System.out.println("Aucun chemin trouvé !");
            return new Chemin(new ArrayList<>());
        }

        System.out.print("Chemin: ");
        List<Case> cheminCases = new ArrayList<>();
        for (Noeud<Case> noeud : chemin) {
            Case caseNode = noeud.getValeur();
            cheminCases.add(caseNode);
            System.out.print(" -> " + caseNode.toString());
        }
        System.out.println();

        return new Chemin(cheminCases);
    }
}
