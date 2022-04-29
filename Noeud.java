
public class Noeud {
	
	public int n ; // nombre d'objet
	public float E=0; // l'evaluation 
	public int idex;
	public boolean s;
	public int level; 
	public boolean[] solution  = new boolean[n];
	
    public Noeud( int n,int idex, boolean s, int level) {
		
		this.n =n;
		this.idex =idex;
		this.level=level;
		this.s=s;
		solution[idex] = s;
     }
    
   
    public float E_noeud() {
    	
    	//la calcule ...
    	return this.E;
    }
    
 

}
