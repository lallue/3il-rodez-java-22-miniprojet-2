package fr.ecole3il.rodez2023.carte.chemin.algorithmes;


import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.*;

public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {

    protected double heuristique(Noeud<E> n, Noeud<E> cible) {
        // Définir votre propre heuristique significative ici
        return 0;
    }

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

    private LinkedList<Noeud<E>> reconstruireChemin(Map<Noeud<E>, Noeud<E>> predecesseur, Noeud<E> cible, Noeud<E> debut) {
        LinkedList<Noeud<E>> chemin = new LinkedList<>();
        Noeud<E> courant = cible;
        while (courant != null) {
            chemin.addFirst(courant);
            courant = predecesseur.get(courant);
        }
        if (chemin.getFirst().equals(debut))
            return chemin;
        else
            return new LinkedList<>();  // No path found
    }
    }
