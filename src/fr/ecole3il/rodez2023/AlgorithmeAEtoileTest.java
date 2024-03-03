package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeAEtoile;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmeAEtoileTest {

    @Test
    public void testTrouverChemin() {
        Graphe<Integer> graphe = new Graphe<>();
        Noeud<Integer> noeud1 = new Noeud<>(1);
        Noeud<Integer> noeud2 = new Noeud<>(2);
        graphe.ajouterNoeud(noeud1);
        graphe.ajouterNoeud(noeud2);
        graphe.ajouterArete(noeud1, noeud2, 1.0);

        Noeud<Integer> debut = new Noeud<>(1);
        Noeud<Integer> cible = new Noeud<>(2);

        AlgorithmeAEtoile<Integer> algorithme = new AlgorithmeAEtoile<>();

        List<Noeud<Integer>> chemin = algorithme.trouverChemin(graphe, debut, cible);

        System.out.println("Chemin trouvé : " + chemin);

        assertNotNull(chemin);
    }
}

