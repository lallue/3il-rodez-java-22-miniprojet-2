# Miniprojet 2 >.<

## Question :

### Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe et les informations associées à ces relations, comme les coûts des arêtes ?

Pour stocker les relations entre les nœuds et les coûts des arêtes dans un graphe, on peut utiliser une matrice d'adjacence, permettant un accès rapide mais utilisant plus d'espace, ou une liste d'adjacence, plus économique en espace mémoire mais nécessitant des recherches plus longues. Le choix dépend de la densité du graphe, des opérations fréquemment réalisées, et des contraintes de mémoire.


## Question :

###  Pourquoi pensez-vous que les classes `Noeud` et `Graphe` ont été définies avec des paramètres génériques ?


Les classes `Noeud` et `Graphe` ont été définies avec des paramètres génériques pour favoriser la réutilisabilité et la flexibilité du code. Cela permet d'adapter ces classes à différents types de données sans modification du code, favorise l'abstraction en ignorant les détails spécifiques du type, évite la duplication de code, et rend le code plus générique et maintenable dans des contextes variés.

## Question : 

### Pourquoi pensez-vous que la création d'une interface est une bonne pratique dans ce contexte ?


La création de l'interface `AlgorithmeChemin<E>` est une bonne pratique car elle permet d'abstraire les détails d'implémentation, favorise la flexibilité en facilitant l'ajout de nouveaux algorithmes, assure la compatibilité entre différentes implémentations, facilite les tests, améliore la clarté du code et est conforme aux principes SOLID. En résumé, elle contribue à une conception logicielle plus robuste et maintenable dans le contexte des algorithmes de recherche de chemin.


# Projet de Recherche de Chemin sur Carte

Ce projet vise à fournir une solution logicielle pour trouver le chemin le plus court entre deux points sur une carte donnée, en utilisant des algorithmes de recherche de chemin tels que Dijkstra et A*. Le projet comprend une structure de classes permettant de représenter un graphe, d'implémenter ces algorithmes et d'adapter leur utilisation à une interface utilisateur.

## Fonctionnalités

- Recherche de chemin optimisé : Trouvez efficacement le chemin le plus court entre deux points sur une carte à l'aide d'algorithmes avancés.
- Adaptabilité : Les classes `Noeud` et `Graphe` sont définies avec des paramètres génériques pour permettre une adaptation facile à différents types de données.
- Interface utilisateur : La classe `AdaptateurAlgorithme` agit comme un pont entre le code de calcul de chemin et l'interface utilisateur, permettant une intégration transparente dans un système plus large.

## Utilisation

Pour utiliser ce projet, suivez ces étapes :

1. **Importer le projet :** Clonez ce dépôt sur votre machine locale.
2. **Compiler le code :** Compilez les fichiers source à l'aide d'un compilateur Java compatible.
3. **Lancement:** Utilisez la classe `CarteGUI.java` pour lancer la vue.

## Points Difficiles

- **Paramètres Génériques :** La gestion des paramètres génériques dans les classes `Noeud` et `Graphe` a nécessité une compréhension approfondie des concepts de généricité en Java.
- **Implémentation de A* :** L'implémentation de l'algorithme A* a été un défi en raison de sa complexité, en particulier pour la conception d'une heuristique efficace pour guider la recherche du chemin optimal.
- **Modification de classe :** Adapter la classe `Carte` pour permettre l'affichage du chemin a été la partie la plus complexe du projet, nécessitant une compréhension approfondie de la structure de code existante.

## Que le code soit avec vous 🌌🔫🆕🙏

# SIGNE ALLUE Luc