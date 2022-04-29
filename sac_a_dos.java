
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class sac_a_dos {

    private List<objets> liste_d_objets;
    private List<objets> liste_d_objets_best;
    private float poids_optimale;
    private float valeur_optimale;
    private float P_max;

 
    public sac_a_dos() {
    	
        this.liste_d_objets_best = new ArrayList<>();
        this.liste_d_objets = new ArrayList<>();
        this.valeur_optimale = 0;
        this.poids_optimale = 0;
    }


    public sac_a_dos(float poidsMaximal) {

        this.liste_d_objets = new ArrayList<>();
        this.liste_d_objets_best = new ArrayList<>();

        
        Scanner objt = new Scanner(System.in);
        System.out.print(" - le nombre des objets: ");
         int n= objt.nextInt();
         System.out.println();
         read_objets(n);
        
        this.P_max=poidsMaximal;

    }

    
    // la fonction de lecture des objets :
    
   public void read_objets(int nbr) {
	   
        float poids;
        float utilite;
        objets Objet;
        
        Scanner obj = new Scanner(System.in);
        System.out.println(" - Tapez les details des objets :");
        
        for(int i = 0 ; i < nbr ; i++) {
        	
                System.out.print("le Poid : ");
                poids = obj.nextInt();
                
                System.out.print("l'utilite : ");
                utilite= obj.nextInt();
                
                Objet = new objets(poids,utilite,i);
               
                liste_d_objets.add(Objet);
            }
   
    }

   // la fonction d'affichage de solution :
   
    public void AfficheSolution() {
    	
    	System.out.println(" la meilleure solution realisable : ");
    	
    	Poid_optimale();
        
        for (objets obj : liste_d_objets_best) 
            System.out.println(obj.affiche_x());
           
     // System.out.println("les autres valeurs = null");
      
      System.out.println("le poids : " + poids_optimale + " et  Z = : " + valeur_optimale);
       
    }
    
    public void solution_initiale(float P_max ,List<objets> liste_objets){
   
    float gauche = this.P_max;
    float z = 0;
    
   
    System.out.println(" la solution initiale de ce sac a dos :  ");
    
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
      System.out.println(" Z = " + z);
     
      }
   
   
   // Trie la liste d'objet
    public void tri() {
        Collections.sort(liste_d_objets);  
    }
  

    //  la valeur  optimale :
    public void optimale() {
    	
        float optiml = 0;
        
        for (objets obj : liste_d_objets_best) {
        	optiml= optiml + obj.getUtulite();
        } 
        
        this.valeur_optimale = optiml;
    }
  
    
    //le poids de la solution optimale :
    public void  Poid_optimale () {
        float p_optm = 0;

        for (objets obj : liste_d_objets_best) {
        	p_optm = p_optm + obj.getPoids();
        }

        this.poids_optimale = p_optm;
    }

   
    // l'implementation de la methode Branch & Bround :
    public void Branch_Bround() {
    	
    	// 1/ le trie des objet :
       tri();
       
        // 2/ la recherche de la solution initiale :
       solution_initiale(P_max,liste_d_objets);
       
       // 3/ le recuperation de la meuilleure solution :
       new Noeud( P_max ,liste_d_objets);
        valeur_optimale = Noeud.Best;
        liste_d_objets_best = new ArrayList<>(Noeud.Best_objets);
    }
    
}




