package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GrapheTest {

    @Test
    public void testAjouterNoeud() {
        Graphe<Integer> graphe = new Graphe<>();
        Noeud<Integer> noeud1 = new Noeud<>(1);

        graphe.ajouterNoeud(noeud1);

        List<Noeud<Integer>> noeuds = graphe.getNoeuds();

        assertNotNull(noeuds);
        assertEquals(1, noeuds.size());
        assertTrue(noeuds.contains(noeud1));
    }

    @Test
    public void testAjouterArete() {
        Graphe<String> graphe = new Graphe<>();
        Noeud<String> noeudA = new Noeud<>("A");
        Noeud<String> noeudB = new Noeud<>("B");

        graphe.ajouterArete(noeudA, noeudB, 2.5);

        List<Noeud<String>> voisinsA = graphe.getVoisins(noeudA);

        assertNotNull(voisinsA);
        assertEquals(1, voisinsA.size());
        assertTrue(voisinsA.contains(noeudB));

        assertEquals(2.5, graphe.getCoutArete(noeudA, noeudB));
    }

    @Test
    public void testGetVoisins() {
        Graphe<Character> graphe = new Graphe<>();
        Noeud<Character> noeudX = new Noeud<>('X');
        Noeud<Character> noeudY = new Noeud<>('Y');
        Noeud<Character> noeudZ = new Noeud<>('Z');

        graphe.ajouterArete(noeudX, noeudY, 1.0);
        graphe.ajouterArete(noeudX, noeudZ, 2.0);

        List<Noeud<Character>> voisinsX = graphe.getVoisins(noeudX);

        assertNotNull(voisinsX);
        assertEquals(2, voisinsX.size());
        assertTrue(voisinsX.contains(noeudY));
        assertTrue(voisinsX.contains(noeudZ));
    }
}
