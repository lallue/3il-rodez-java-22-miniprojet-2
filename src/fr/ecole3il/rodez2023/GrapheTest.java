package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient les tests unitaires pour la classe Graphe.
 */
public class GrapheTest {

    /**
     * Teste la méthode ajouterNoeud de la classe Graphe.
     */
    @Test
    public void testAjouterNoeud() {
        // Création d'un graphe et d'un noeud
        Graphe<Integer> graphe = new Graphe<>();
        Noeud<Integer> noeud1 = new Noeud<>(1);

        // Ajout du noeud au graphe
        graphe.ajouterNoeud(noeud1);

        // Récupération de la liste des noeuds du graphe
        List<Noeud<Integer>> noeuds = graphe.getNoeuds();

        // Vérification que la liste n'est pas nulle et contient le noeud ajouté
        assertNotNull(noeuds);
        assertEquals(1, noeuds.size());
        assertTrue(noeuds.contains(noeud1));
    }

    /**
     * Teste la méthode ajouterArete de la classe Graphe.
     */
    @Test
    public void testAjouterArete() {
        // Création d'un graphe et de deux noeuds
        Graphe<String> graphe = new Graphe<>();
        Noeud<String> noeudA = new Noeud<>("A");
        Noeud<String> noeudB = new Noeud<>("B");

        // Ajout d'une arête entre les deux noeuds avec un poids de 2.5
        graphe.ajouterArete(noeudA, noeudB, 2.5);

        // Récupération des voisins du noeudA
        List<Noeud<String>> voisinsA = graphe.getVoisins(noeudA);

        // Vérification que la liste de voisins n'est pas nulle et contient le noeudB
        assertNotNull(voisinsA);
        assertEquals(1, voisinsA.size());
        assertTrue(voisinsA.contains(noeudB));

        // Vérification du poids de l'arête entre les noeuds A et B
        assertEquals(2.5, graphe.getCoutArete(noeudA, noeudB));
    }

    /**
     * Teste la méthode getVoisins de la classe Graphe.
     */
    @Test
    public void testGetVoisins() {
        // Création d'un graphe et de trois noeuds
        Graphe<Character> graphe = new Graphe<>();
        Noeud<Character> noeudX = new Noeud<>('X');
        Noeud<Character> noeudY = new Noeud<>('Y');
        Noeud<Character> noeudZ = new Noeud<>('Z');

        // Ajout d'arêtes entre le noeud X et les noeuds Y et Z
        graphe.ajouterArete(noeudX, noeudY, 1.0);
        graphe.ajouterArete(noeudX, noeudZ, 2.0);

        // Récupération des voisins du noeud X
        List<Noeud<Character>> voisinsX = graphe.getVoisins(noeudX);

        // Vérification que la liste de voisins n'est pas nulle et contient les noeuds Y
        // et Z
        assertNotNull(voisinsX);
        assertEquals(2, voisinsX.size());
        assertTrue(voisinsX.contains(noeudY));
        assertTrue(voisinsX.contains(noeudZ));
    }
}
