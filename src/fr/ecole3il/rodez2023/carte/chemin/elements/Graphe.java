package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Graphe<E> {
	
	private Map<Noeud<E>, Map<Noeud<E>, Double >> matriceAdj;
	private List<Noeud<E>> noeuds;
	
	public Graphe() {
		this.matriceAdj = new HashMap<>();
		this.noeuds = new ArrayList<>();	
	}
	public void ajouterNoeud(Noeud<E> noeud) {
		if(!noeuds.contains(noeud)) {
			noeuds.add(noeud);
			matriceAdj.put(noeud, new HashMap<>());
		}
	}
	
	public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
		ajouterNoeud(depart);
		ajouterNoeud(arrivee);
		this.matriceAdj.get(depart).put(arrivee, cout);		
	}
	
	public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
		if (matriceAdj.containsKey(depart)) {
			Map<Noeud<E>, Double> aretesAdjacentes = matriceAdj.get(depart);
			if (aretesAdjacentes.containsKey(arrivee))
				return aretesAdjacentes.get(arrivee);
		}
		//expliquer pourquoi j'ai utiliser (double) null
		return Double.POSITIVE_INFINITY;
	}
	
	public List<Noeud<E>> getNoeuds(){
		return new ArrayList<>(noeuds);
	}
	
	public List<Noeud<E>> getVoisins(Noeud<E> noeud){
		if(!this.matriceAdj.containsKey(noeud))
			return new ArrayList<>();
		return new ArrayList<>(this.matriceAdj.get(noeud).keySet());
	}
}
