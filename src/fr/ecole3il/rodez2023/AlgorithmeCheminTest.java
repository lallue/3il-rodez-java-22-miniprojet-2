package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeDijkstra;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmeCheminTest {

    @Test
    public void testTrouverChemin() {
        Graphe<Integer> graphe = new Graphe<>();
        Noeud<Integer> noeud1 = new Noeud<>(1);
        Noeud<Integer> noeud2 = new Noeud<>(2);
        Noeud<Integer> noeud3 = new Noeud<>(3);

        graphe.ajouterArete(noeud1, noeud2, 1.0);
        graphe.ajouterArete(noeud2, noeud3, 2.0);

        AlgorithmeChemin<Integer> algorithme = new AlgorithmeDijkstra<>(); 

        List<Noeud<Integer>> chemin = algorithme.trouverChemin(graphe, noeud1, noeud3);
        assertNotNull(chemin);
        assertEquals(3, chemin.size());
        assertEquals(noeud1, chemin.get(0));
        assertEquals(noeud2, chemin.get(1));
        assertEquals(noeud3, chemin.get(2));
    }
}