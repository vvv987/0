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

# Question 4
l'implémentation de la méthode de Branch & bound

# Question 5
la solution optimale de P : 

# Question 6
l'affichage de l’arbre de séparation (l’arborescence de résolution)
