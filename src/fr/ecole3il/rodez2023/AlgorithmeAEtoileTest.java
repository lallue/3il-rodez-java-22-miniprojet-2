package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeAEtoile;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient les tests unitaires pour la classe AlgorithmeAEtoile.
 */
public class AlgorithmeAEtoileTest {

    /**
     * Teste la méthode trouverChemin de la classe AlgorithmeAEtoile.
     */
    @Test
    public void testTrouverChemin() {
        // Création d'un graphe avec des noeuds et une arête
        Graphe<Integer> graphe = new Graphe<>();
        Noeud<Integer> noeud1 = new Noeud<>(1);
        Noeud<Integer> noeud2 = new Noeud<>(2);

        // Ajout des noeuds au graphe
        graphe.ajouterNoeud(noeud1);
        graphe.ajouterNoeud(noeud2);

        // Ajout d'une arête entre les noeuds 1 et 2
        graphe.ajouterArete(noeud1, noeud2, 1.0);

        // Définition du noeud de départ et du noeud cible
        Noeud<Integer> debut = new Noeud<>(1);
        Noeud<Integer> cible = new Noeud<>(2);

        // Création de l'algorithme A* pour trouver le chemin
        AlgorithmeAEtoile<Integer> algorithme = new AlgorithmeAEtoile<>();

        // Recherche du chemin entre le noeud de départ et le noeud cible dans le graphe
        List<Noeud<Integer>> chemin = algorithme.trouverChemin(graphe, debut, cible);

        // Affichage du chemin trouvé
        System.out.println("Chemin trouvé : " + chemin);

        // Vérification que le chemin trouvé n'est pas nul
        assertNotNull(chemin);
    }
}
