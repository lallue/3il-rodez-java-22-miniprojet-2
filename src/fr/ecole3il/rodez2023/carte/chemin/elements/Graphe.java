package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Cette classe représente un graphe.
 *
 * @param <E> Le type de valeur associée aux noeuds du graphe.
 */
public class Graphe<E> {

    private Map<Noeud<E>, Map<Noeud<E>, Double>> matriceAdj;
    private List<Noeud<E>> noeuds;

    /**
     * Constructeur de la classe Graphe.
     */
    public Graphe() {
        this.matriceAdj = new HashMap<>();
        this.noeuds = new ArrayList<>();
    }

    /**
     * Ajoute un noeud au graphe s'il n'existe pas déjà.
     *
     * @param noeud Le noeud à ajouter.
     */
    public void ajouterNoeud(Noeud<E> noeud) {
        if (!noeuds.contains(noeud)) {
            noeuds.add(noeud);
            matriceAdj.put(noeud, new HashMap<>());
        }
    }

    /**
     * Ajoute une arête entre deux noeuds avec un certain coût.
     *
     * @param depart  Le noeud de départ de l'arête.
     * @param arrivee Le noeud d'arrivée de l'arête.
     * @param cout    Le coût de l'arête.
     */
    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
        ajouterNoeud(depart);
        ajouterNoeud(arrivee);
        this.matriceAdj.get(depart).put(arrivee, cout);
    }

    /**
     * Obtient le coût d'une arête entre deux noeuds.
     *
     * @param depart   Le noeud de départ de l'arête.
     * @param arrivee  Le noeud d'arrivée de l'arête.
     * @return Le coût de l'arête entre les deux noeuds.
     */
    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
        if (matriceAdj.containsKey(depart)) {
            Map<Noeud<E>, Double> aretesAdjacentes = matriceAdj.get(depart);
            if (aretesAdjacentes.containsKey(arrivee))
                return aretesAdjacentes.get(arrivee);
        }
        // Renvoie une valeur infinie si aucune arête n'existe entre les noeuds
        return Double.POSITIVE_INFINITY;
    }

    /**
     * Obtient la liste de tous les noeuds du graphe.
     *
     * @return La liste de tous les noeuds du graphe.
     */
    public List<Noeud<E>> getNoeuds() {
        return new ArrayList<>(noeuds);
    }

    /**
     * Obtient la liste des voisins d'un noeud donné.
     *
     * @param noeud Le noeud dont on veut obtenir les voisins.
     * @return La liste des voisins du noeud donné.
     */
    public List<Noeud<E>> getVoisins(Noeud<E> noeud) {
        if (!this.matriceAdj.containsKey(noeud))
            return new ArrayList<>();
        return new ArrayList<>(this.matriceAdj.get(noeud).keySet());
    }
}
