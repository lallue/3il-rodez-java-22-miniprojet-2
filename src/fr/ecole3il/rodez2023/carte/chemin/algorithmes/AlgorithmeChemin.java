package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.List;

public interface AlgorithmeChemin<E> {

    /**
     * Trouve un chemin entre un nœud de départ et un nœud d'arrivée dans un graphe
     * donné.
     *
     * @param graphe  Le graphe dans lequel la recherche doit être effectuée.
     * @param depart  Le nœud de départ.
     * @param arrivee Le nœud d'arrivée.
     * @return Une liste de nœuds représentant le chemin trouvé entre le nœud de
     *         départ et le nœud d'arrivée.
     */
    List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);
}
