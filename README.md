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

## Que le code soit avec vous 🌌🔫🆕🙏

# SIGNE ALLUE Luc