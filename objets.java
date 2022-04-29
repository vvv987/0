
public class objets {
	
	public float poid ; //poid des objets
	public float utilite ; //l'utilite des objets
	public String name;
	public float rapport;

	public objets(int poid, int utilite, String name) {
		
	this.name =name;
    	this.poid = poid;
    	this.utilite = utilite;
    	this.rapport = this.utilite / this.poid ;
     }
	
}
