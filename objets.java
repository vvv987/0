public class objets implements Comparable<objets> {

    public float poids;
    public float utulite;
    public int indice;
    public float rapport;
    public objets(float poids, float utulite,int indice) {
    	
        this.poids = poids;
        this.utulite = utulite;
        this.indice  = indice; 
        this.rapport = utulite / poids;
       
    }

    void setPoids(float poids) {
        this.poids = poids;
    }
    
    //les getter :
    float getPoids() {
        return poids;
    }

    float getUtulite() {
        return utulite;
    }

    int getIndice(){
	    return indice;
	  }
    
    float getRapport() {
        return rapport;
    }
     
    public String affiche_x() {
         
         return " x" + this.indice+" = 1" ;
     }

    public int compareTo(objets obj) {
 
        if (getRapport() - obj.getRapport() > 0) return -1;
        else if (getRapport() - obj.getRapport() < 0) return 1;
        else  return 0;
        
    }

   
}
