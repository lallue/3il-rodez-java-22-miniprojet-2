package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Case;

import java.util.*;

/**
 * Implémentation de l'algorithme A* pour trouver le chemin le plus court entre deux nœuds dans un graphe.
 *
 * @param <E> Le type de valeur associée aux nœuds du graphe.
 */
public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {

    /**
     * Calcule l'heuristique entre un nœud donné et un nœud cible.
     *
     * @param n     Le nœud pour lequel calculer l'heuristique.
     * @param cible Le nœud cible.
     * @return La valeur de l'heuristique entre les deux nœuds.
     */
    private double heuristique(Noeud<E> n, Noeud<E> cible) {
        Case caseN = (Case) n.getValeur(); // Récupération de la case associée au nœud
        Case caseCible = (Case) cible.getValeur(); // Récupération de la case associée à la cible

        // Calcul de la distance euclidienne entre les coordonnées (x, y) des deux cases
        double dx = Math.abs(caseN.getX() - caseCible.getX());
        double dy = Math.abs(caseN.getY() - caseCible.getY());
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Trouve un chemin entre un nœud de départ et un nœud d'arrivée dans un graphe donné.
     *
     * @param graphe Le graphe dans lequel la recherche doit être effectuée.
     * @param debut  Le nœud de départ.
     * @param cible  Le nœud d'arrivée.
     * @return Une liste de nœuds représentant le chemin trouvé entre le nœud de départ et le nœud d'arrivée.
     */
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> debut, Noeud<E> cible) {
        Map<Noeud<E>, Double> coutActuel = new HashMap<>();
        Map<Noeud<E>, Double> coutTotalEstime = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> precedent = new HashMap<>();
        Set<Noeud<E>> explore = new HashSet<>();
        PriorityQueue<Noeud<E>> filePrioritaire = new PriorityQueue<>(Comparator.comparingDouble(coutTotalEstime::get));

        for (Noeud<E> noeud : graphe.getNoeuds()) {
            coutTotalEstime.put(noeud, Double.POSITIVE_INFINITY);
            coutActuel.put(noeud, Double.POSITIVE_INFINITY);
            precedent.put(noeud, null);
        }
        coutActuel.put(debut, 0.0);
        coutTotalEstime.put(debut, heuristique(debut, cible));
        filePrioritaire.add(debut);

        while (!filePrioritaire.isEmpty()) {
            Noeud<E> courant = filePrioritaire.poll();
            if (courant.equals(cible))
                break;
            explore.add(courant);

            for (Noeud<E> voisin : graphe.getVoisins(courant)) {
                if (explore.contains(voisin))
                    continue;

                double nouveauCout = coutActuel.get(courant) + graphe.getCoutArete(courant, voisin);
                if (nouveauCout < coutActuel.get(voisin)) {
                    precedent.put(voisin, courant);
                    coutActuel.put(voisin, nouveauCout);
                    coutTotalEstime.put(voisin, coutActuel.get(voisin) + heuristique(voisin, cible));
                    if (!filePrioritaire.contains(voisin))
                        filePrioritaire.add(voisin);
                }
            }
        }

        LinkedList<Noeud<E>> chemin = reconstruireChemin(precedent, cible, debut);
        Collections.reverse(chemin);

        return new ArrayList<>(chemin);
    }

    /**
     * Reconstruit le chemin à partir des prédécesseurs.
     *
     * @param predecesseur La map des prédécesseurs.
     * @param cible        Le nœud cible.
     * @param debut        Le nœud de départ.
     * @return Le chemin reconstruit.
     */
    private LinkedList<Noeud<E>> reconstruireChemin(Map<Noeud<E>, Noeud<E>> predecesseur, Noeud<E> cible, Noeud<E> debut) {
        LinkedList<Noeud<E>> chemin = new LinkedList<>();
        Noeud<E> courant = cible;
        while (courant != null) {
            chemin.add(courant);
            courant = predecesseur.get(courant);
        }
        Collections.reverse(chemin);

        return chemin;
    }    
}
