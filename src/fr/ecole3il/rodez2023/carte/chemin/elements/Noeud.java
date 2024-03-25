package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un noeud dans un graphe.
 *
 * @param <E> Le type de valeur associée au noeud.
 */
public class Noeud<E> {

    private E valeur;
    private List<Noeud<E>> voisins;

    /**
     * Constructeur de la classe Noeud.
     *
     * @param valeur La valeur associée au noeud.
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<>();
    }

    /**
     * Retourne la valeur associée au noeud.
     *
     * @return La valeur du noeud.
     */
    public E getValeur() {
        return this.valeur;
    }

    /**
     * Retourne la liste des noeuds voisins.
     *
     * @return La liste des voisins du noeud.
     */
    public List<Noeud<E>> getVoisins() {
        return this.voisins;
    }

    /**
     * Ajoute un noeud voisin.
     *
     * @param voisin Le noeud voisin à ajouter.
     */
    public void ajouterVoisin(Noeud<E> voisin) {
        this.voisins.add(voisin);
        voisin.voisins.add(this);
    }
}
