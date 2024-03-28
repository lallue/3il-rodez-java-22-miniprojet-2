package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.*;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

/**
 * Cette classe implémente l'algorithme de Dijkstra pour trouver le chemin le
 * plus court dans un graphe pondéré.
 *
 * @param <E> Le type de valeur associée aux noeuds du graphe.
 */
public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

    /**
     * Trouve le chemin le plus court entre deux noeuds dans un graphe pondéré en
     * utilisant l'algorithme de Dijkstra.
     *
     * @param graphe  Le graphe dans lequel trouver le chemin.
     * @param depart  Le noeud de départ.
     * @param arrivee Le noeud d'arrivée.
     * @return Le chemin le plus court entre le noeud de départ et le noeud
     *         d'arrivée.
     */
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        // Initialisation des structures de données nécessaires à l'algorithme
        Map<Noeud<E>, Noeud<E>> precedent = new HashMap<>();
        Map<Noeud<E>, Double> distance = new HashMap<>();
        PriorityQueue<Noeud<E>> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));

        // Initialisation des distances à l'infini et des précédents à null pour tous
        // les noeuds du graphe
        for (Noeud<E> noeud : graphe.getNoeuds()) {
            distance.put(noeud, Double.POSITIVE_INFINITY);
            precedent.put(noeud, null);
        }

        // Distance du noeud de départ à lui-même est de 0
        distance.put(depart, 0.0);
        queue.add(depart);

        // Boucle principale de l'algorithme
        while (!queue.isEmpty()) {
            Noeud<E> noeudActuel = queue.poll();

            // Si on a atteint le noeud d'arrivée, on sort de la boucle
            if (noeudActuel.equals(arrivee)) {
                break;
            }

            // Parcours des voisins du noeud actuel
            for (Noeud<E> voisin : graphe.getVoisins(noeudActuel)) {
                // Calcul de la nouvelle distance
                double nouveauDistance = distance.get(noeudActuel) + graphe.getCoutArete(noeudActuel, voisin);

                // Si la nouvelle distance est plus courte que celle enregistrée, on met à jour
                if (nouveauDistance < distance.get(voisin)) {
                    distance.put(voisin, nouveauDistance);
                    precedent.put(voisin, noeudActuel);
                    queue.offer(voisin);
                }
            }
        }

        // Reconstruction du chemin à partir des précédents
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeudActuel = arrivee;

        while (noeudActuel != null) {
            chemin.add(noeudActuel);
            noeudActuel = precedent.get(noeudActuel);
        }

        // Inversion du chemin pour qu'il soit dans l'ordre du départ à l'arrivée
        Collections.reverse(chemin);

        return chemin;
    }
}
