# 0
## Question 1
l’algorithme de Tri des objets en ordre décroissant du rapport ci/ Pi :

```

import java.util.Collections;

Collections.sort(liste_d_objets); 

```

## Question 2
la fonction de recherche d’une solution initiale :  
 - on soustraire les poids d'objet par ordre de poids max , jusqu'a ou le poid reste disponible est null 

```

 for(objets obj : liste_objets)
    { 
        if(obj.getPoids() <= gauche){
        	
        	System.out.println("  x"+ obj.getIndice()+" = 1");
            gauche = gauche - obj.getPoids();
             z = z+ obj.getUtulite();
        }
        else if(obj.getPoids()>gauche && gauche!=0 ){
        	
            System.out.println("  x"+obj.getIndice()+" = "+ gauche/obj.getPoids());
            z=z+obj.getUtulite()*(gauche/obj.getPoids());
            gauche=0;
        } 
        else
            System.out.println("  x"+ obj.getIndice()+" = 0 ");
            
    } 

```

## Question 3
 - ### fonction de séparation :
 
 ```

Noeud  right , left;

        if (superieure() > Best && !this.list_objets_rest.isEmpty() && nextobjet() ) {
        	
        	left = new Noeud(this.list_objets,this.list_objets_rest,  true);
        	right = new Noeud(this.list_objets,this.list_objets_rest,  false);

        } 
        else if (superieure() > Best && !this.list_objets_rest.isEmpty() && !nextobjet() ) {
        	
        	left = new Noeud( this.list_objets,this.list_objets_rest, true);
        	right = null;

        } 
        else  left = right = null; 

```
 - ### fonction d’évaluation

```
    	return (superieure() > Best);
    
```

## Question 4
l'implémentation de la méthode de Branch & bound :
```
      	// 1/ le trie des objet :
       tri();
       
        // 2/ la recherche de la solution initiale :
       solution_initiale(P_max,liste_d_objets);
       
       // 3/ le recuperation de la meuilleure solution :
        new Noeud( P_max ,liste_d_objets);
        valeur_optimale = Noeud.Best;
        liste_d_objets_best = new ArrayList<>(Noeud.Best_objets);
    
```

## Question 5
la solution optimale de P : Z = : 37.0  (1,1,0,0,0,1)

le poid = 17

x1 = 1 | x2 = 1 | x3 = 0 | x4 = 0 | x5 = 0 | x6 = 1 

![image](https://user-images.githubusercontent.com/104647979/166072099-a4949920-6b08-40fa-97b3-8e2a50e67094.png)

# Question 6
l'affichage de l’arbre de séparation (l’arborescence de résolution)
