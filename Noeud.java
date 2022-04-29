
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Noeud {
	
	
    static List<objets> Best_objets;
    static float Best;
    private static float P_max;
    private List<objets> list_objets_rest;
    private List<objets> list_objets;


    Noeud(float P_max , List<objets> objets) {

        this.list_objets_rest = new ArrayList<>(objets);
        this.list_objets = new ArrayList<>();
        this.P_max = P_max;

        la_separation();
    }

 
    private void la_separation() {

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
         
    }


    private Noeud(List<objets> list_objets, List<objets> list_objets_rest,  boolean left) {

         
        this.list_objets_rest = new ArrayList<>(list_objets_rest);
        this.list_objets = new ArrayList<>(list_objets);


        if (left) {
        	
             this.list_objets_rest.remove(this.list_objets_rest.get(0));
        } 
        else {

            this.list_objets.add(this.list_objets_rest.get(0));
            this.list_objets_rest.remove(this.list_objets_rest.get(0));
        }

        // la mis a jour :
        mettre_a_jrs();

        la_separation();
    }
    
    
    // la borne superieure :
    private float superieure() {
    	
        float b = 0;
        
        for (objets obj : list_objets) {
            b = b + obj.getUtulite();
        }

        for (objets obj : list_objets_rest) {
            b = b + obj.getUtulite();
        }

        return b;
    }

    private void mettre_a_jrs() {
        float bst = 0;

        if (this.list_objets != null) {
            for (objets obj : this.list_objets) {
                bst = bst +  obj.getUtulite();
            }
        }
 
        if (Best< bst) {
        	Best = bst;
        	Best_objets = new ArrayList<>(list_objets);
        }
    }


    private boolean nextobjet() {
    	
        float next = this.list_objets_rest.get(0).getPoids(); 
        
        if (!this.list_objets.isEmpty()) {
        	
            for (objets obj : list_objets) {
            	next = next + obj.getPoids();
            }
        }
        return (next <= P_max);
    }
    

}
