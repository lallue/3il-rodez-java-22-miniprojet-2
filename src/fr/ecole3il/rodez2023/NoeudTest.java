package fr.ecole3il.rodez2023;

import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NoeudTest {

	@Test
	public void testAjouterVoisin() {
	    Noeud<String> noeudA = new Noeud<>("A");
	    Noeud<String> noeudB = new Noeud<>("B");

	    assertNotNull(noeudA.getVoisins());
	    assertTrue(noeudA.getVoisins().isEmpty());

	    noeudA.ajouterVoisin(noeudB);

	    System.out.println("Voisins de A après ajout de B : " + noeudA.getVoisins());

	    List<Noeud<String>> voisinsA = noeudA.getVoisins();
	    List<Noeud<String>> voisinsB = noeudB.getVoisins();

	    assertTrue(voisinsA.contains(noeudB), "B devrait être un voisin de A");
	    assertTrue(voisinsB.contains(noeudA), "A devrait être un voisin de B");
	}

}
