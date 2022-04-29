import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sac_a_dos {
	
	
	public int P_max ; // le poids maximum supporté par le sac a dos
	public int n ; //nombre d'objet dans le sac a dos dans cet exemple
	public objets[] objets =  new objets[n];
	public objets[] objets_trie =  new objets[n]; 
	public boolean[] objets_m = new boolean[n];
	public float E_init ;
	

	public sac_a_dos(int P_max, int n,objets[] objets) {
    	this.P_max = P_max;
    	this.n = n;
    	this.objets = objets;
    	this.objets_m=null;
    	this.objets_trie= this.objets;
    	this.E_init=0;
    	
     }
	
	
	  //affichage des poids des objets par ordre
	public void affichage_des_poids() {
		
		System.out.println("l'affichage des poids :");
		System.out.println("");
	    for ( int i=0; i<this.n; i++ ) {
	    	System.out.println("  le poid de l'objet " + (i+1) +"=" +this.objets[i].poid);
	    	
	    }
	    
	    System.out.println("\n");
	}
	
	 //affichage utilité
		public void affichage_d_utilite() {
			
			System.out.println("l'affichage d utilite :");
			System.out.println("");
		    for ( int i=0; i<this.n; i++ ) {
		    	System.out.println("  l'utilité de l'objet " + (i+1) +"=" +this.objets[i].utilite);
		    	
		    }
		    
		    System.out.println("\n");
		}
		
	//affichage du rapport Ui/Pi
         public void affichage_de_rapport() { 
        	 System.out.println( "le rapport entre l'utilite et le poids Ui/ Pi pour chaque objet : " );
        	 System.out.println("");
        	 for ( int i=0; i<this.n; i++ ) {
 		    	System.out.println("  le rapport de l'objet " + (i+1) +" = " +this.objets[i].rapport);
 		    	
 		    }
		}
      
   //le tri des objets :
         public void tri() {

        	 
        	 List<Float> liste;
		     liste = new ArrayList();
		     for ( int i=0; i<this.n; i++ ){
		            liste.add(this.objets[i].rapport);
		        }
		     
		     Collections.sort(liste); //trier
		     
 
		     Collections.reverse(liste);   
		     Collections.sort(liste, Collections.reverseOrder()); //Tri dans l'ordre décroissant
		     System.out.println();
		     System.out.println(liste);// l'affichage de la liste trier
		    
		     int i=0;
		     int j = 0;
		    	 while (j<this.n && i<this.n) {
		    		 
		    	  if (liste.get(i) == this.objets[j].rapport) { 
		    		  
		    		   this.objets_trie[i]= this.objets[j];
		    		   this.objets[j].rapport = 0;
		    		  
		    		   j=0;
		    		   i++;
		    		   
		    	    }
		    	  else {
		    		  j++;}
		    	  }
		    	 
		    	 
		    	 
		    	 // l'affichage de liste trie :
		    	 System.out.println("les objest par ordre :" );
		    	 for ( int k= 0; k<this.n; k++ ){
		    		 System.out.println("  " +this.objets_trie[k].name );
			        }
		         
         } 
	
         
   //le tri des objets :      
         public void solution_initiale() {
        	 float p_reste = this.P_max ;
        	 boolean s =false;
        	 boolean solu[] = new boolean[this.n];
        	 int i =0;
        	 System.out.println(" la solution initiale :");
        	 while(p_reste <= this.P_max && i<this.n && p_reste>this.objets_trie[i].poid)
        	 {
        		 p_reste = p_reste - this.objets_trie[i].poid;
        		 solu[i]=true;
        		 E_init = E_init  + this.objets_trie[i].utilite;
        		 System.out.println(this.objets_trie[i].name + " = 1");
        		 
        		 i++;
        	 }
        	 
        	 if(p_reste == 0) {
        		 solu[i]=false;
        		 s = true;
        	 }
        	 else {
        		 solu[i]=true;
        		 System.out.println(this.objets_trie[i].name + " = " + (p_reste/this.objets_trie[i].poid));
        		 E_init = E_init  + this.objets_trie[i].utilite*(p_reste/this.objets_trie[i].poid);
        		 
        	 }


        	 i++;
        	 while( i<this.n )
        	 { 
        		 System.out.println(this.objets_trie[i].name + " = 0");
        		 solu[i]=false;
        		 i++;
        	 }
        	 
        	 if(s) {
        		 System.out.println("ca c'est un solution realisable !!");
        	 }
        	 
        	 
        	 
         }
         
         
   // la separation :
         public void separation(int i,int l) {
        	 Noeud N1 = new Noeud(this.n,i,true,l);
        	 Noeud N2 = new Noeud(this.n,i,false,l);
         }
       // l'evaluation :
         public boolean evaluation(Noeud n) {
        	 
        	return ( n.E_noeud() > this.E_init);
        		
         }
         
   // l'implementation de la methode  Branch & bound :
         public void Branch_bound(Noeud n, int index, int l ){
        	 
        	 if (!this.evaluation(n)) {
        		 Noeud left = new Noeud(this.n,index, true ,l);
        		 Noeud right = new Noeud(this.n,index, false,l);
        		 
        	 }
        	 else 
        		 this.est_solution();
         }
         
         public void est_solution() {
        	 
        	 System.out.println("soltion :");
        	 for (int i =0 ; i<this.n; i ++ ) {
        		 System.out.println(this.objets[i].name +" -> "+this.objets_m[i]);
        	 }
         	 
         }
}




