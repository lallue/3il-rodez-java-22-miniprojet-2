package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cette classe contient les tests unitaires pour la classe Noeud.
 */
public class NoeudTest {

    /**
     * Teste la méthode ajouterVoisin de la classe Noeud.
     */
    @Test
    public void testAjouterVoisin() {
        // Création des noeuds A et B
        Noeud<String> noeudA = new Noeud<>("A");
        Noeud<String> noeudB = new Noeud<>("B");

        // Vérifie que le noeud A a initialement aucun voisin
        assertNotNull(noeudA.getVoisins());
        assertTrue(noeudA.getVoisins().isEmpty());

        // Ajout de B comme voisin de A
        noeudA.ajouterVoisin(noeudB);

        // Affiche les voisins de A après l'ajout de B
        System.out.println("Voisins de A après ajout de B : " + noeudA.getVoisins());

        // Récupération des listes de voisins de A et B
        List<Noeud<String>> voisinsA = noeudA.getVoisins();
        List<Noeud<String>> voisinsB = noeudB.getVoisins();

        // Vérifie si B est un voisin de A et si A est un voisin de B
        assertTrue(voisinsA.contains(noeudB), "B devrait être un voisin de A");
        assertTrue(voisinsB.contains(noeudA), "A devrait être un voisin de B");
    }
}
