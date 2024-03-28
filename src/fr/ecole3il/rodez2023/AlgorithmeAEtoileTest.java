package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeAEtoile;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

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
        // Création d'un graphe avec des nœuds et une arête
        Graphe<Case> graphe = new Graphe<>();
        Noeud<Case> noeud1 = new Noeud<>(new Case(Tuile.DESERT, 0, 0));
        Noeud<Case> noeud2 = new Noeud<>(new Case(Tuile.PLAINE, 1, 1));

        // Ajout des nœuds au graphe
        graphe.ajouterNoeud(noeud1);
        graphe.ajouterNoeud(noeud2);

        // Ajout d'une arête entre les nœuds 1 et 2
        graphe.ajouterArete(noeud1, noeud2, 1.0);

        // Définition du nœud de départ et du nœud cible
        Noeud<Case> debut = noeud1; // Utilisation du nœud réel
        Noeud<Case> cible = noeud2; // Utilisation du nœud réel

        // Création de l'algorithme A* pour trouver le chemin
        AlgorithmeAEtoile<Case> algorithme = new AlgorithmeAEtoile<>();

        // Recherche du chemin entre le nœud de départ et le nœud cible dans le graphe
        List<Noeud<Case>> chemin = algorithme.trouverChemin(graphe, debut, cible);

        // Affichage du chemin trouvé
        System.out.println("Chemin trouvé : " + chemin);

        // Vérification que le chemin trouvé n'est pas nul
        assertNotNull(chemin);

        // Vérification que le chemin trouvé est correct (optionnel)
        assertEquals(2, chemin.size()); // Le chemin doit contenir exactement deux nœuds (début et cible)
    }
}
