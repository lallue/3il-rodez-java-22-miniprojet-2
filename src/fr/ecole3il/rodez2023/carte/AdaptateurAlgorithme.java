package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe fournit des méthodes statiques pour adapter un algorithme de recherche de chemin à une carte.
 */
public class AdaptateurAlgorithme {

    /**
     * Trouve un chemin sur la carte donnée en utilisant l'algorithme fourni.
     *
     * @param algorithme L'algorithme de recherche de chemin à utiliser.
     * @param carte      La carte sur laquelle le chemin doit être trouvé.
     * @param xDepart    La coordonnée x du point de départ sur la carte.
     * @param yDepart    La coordonnée y du point de départ sur la carte.
     * @param xArrivee   La coordonnée x du point d'arrivée sur la carte.
     * @param yArrivee   La coordonnée y du point d'arrivée sur la carte.
     * @return Le chemin trouvé sur la carte, ou un chemin vide s'il n'y en a pas.
     */
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {

        Graphe<Case> graphe = creerGraphe(carte);
        Noeud<Case> depart = graphe.getNoeud(xDepart, yDepart);
        Noeud<Case> arrivee = graphe.getNoeud(xArrivee, yArrivee);
        List<Noeud<Case>> noeudsChemin = algorithme.trouverChemin(graphe, depart, arrivee);

        if (noeudsChemin == null || noeudsChemin.isEmpty()) {
            return new Chemin(new ArrayList<>());
        }
        return new Chemin(afficherChemin(noeudsChemin));
    }
    
    /**
     * Crée un graphe à partir de la carte donnée.
     *
     * @param carte La carte à partir de laquelle créer le graphe.
     * @return Le graphe créé à partir de la carte.
     */
    private static Graphe<Case> creerGraphe(Carte carte) {
        Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Noeud<Case> currentNoeud = new Noeud<>(carte.getCase(x, y));
                graphe.ajouterNoeud(currentNoeud);
            }
        }
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Noeud<Case> currentNoeud = graphe.getNoeud(x, y);
                ajouterAretesVoisines(graphe, currentNoeud, x, y, largeur, hauteur); 
            }
        }
        return graphe;
    }
    
    /**
     * Ajoute les arêtes aux nœuds voisins du nœud donné dans le graphe.
     *
     * @param graphe       Le graphe auquel ajouter les arêtes.
     * @param currentNoeud Le nœud pour lequel ajouter les arêtes voisines.
     * @param x            La coordonnée x du nœud sur la carte.
     * @param y            La coordonnée y du nœud sur la carte.
     * @param largeur      La largeur de la carte.
     * @param hauteur      La hauteur de la carte.
     */
    private static void ajouterAretesVoisines(Graphe<Case> graphe, Noeud<Case> currentNoeud, int x, int y, int largeur, int hauteur) {
           
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < largeur && newY >= 0 && newY < hauteur) {
                    Noeud<Case> voisinNoeud = graphe.getNoeud(newX, newY);
                    if (voisinNoeud != null) {
                        double cout = calculerCout(currentNoeud.getValeur(), voisinNoeud.getValeur());
                        graphe.ajouterArete(currentNoeud, voisinNoeud, cout);
                        currentNoeud.ajouterVoisin(voisinNoeud);
                    }
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
    private static double calculerCout(Case from, Case to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Les cases doivent être non nulles");
        }
        return from.getTuile().getPenalite() + to.getTuile().getPenalite();
    }
    
    /**
     * Affiche le chemin trouvé sur la carte.
     *
     * @param chemin Le chemin trouvé sur la carte.
     * @return La liste des cases du chemin.
     */
    private static List<Case> afficherChemin(List<Noeud<Case>> chemin) {
        if (chemin.isEmpty()) {
            System.out.println("Aucun chemin trouvé !");
            return new ArrayList<>();
        }
        System.out.print("Chemin: ");
        List<Case> cheminCases = new ArrayList<>();
        for (Noeud<Case> noeud : chemin) {
            Case caseNode = noeud.getValeur();
            cheminCases.add(caseNode);
            System.out.print("\n -> " + caseNode.toString());
        }
        System.out.println();
        
        return cheminCases;
    }
}
