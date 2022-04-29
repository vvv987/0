  
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collections; 
import java.util.List;

public class TP3_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    objets objet1 = new objets(3,8,"objet1");
		    objets objet2 = new objets(7,16,"objet2");
		    objets objet3 = new objets(9,20,"objet3");
		    objets objet4 = new objets(6,12,"objet4");
		    objets objet5 = new objets(3,6,"objet5");
		    objets objet6 = new objets(5,9,"objet6");
		    
		    objets[] liste_objets = {objet1,objet2,objet3,objet4,objet5,objet6};
			int n = 6; //nombre d'objet dans le sac a dos dans cet exemple
			int pmax = 17;  // le poids maximum supporté par le sac a dos
			
			sac_a_dos sac1 = new sac_a_dos(pmax,n,liste_objets);
			sac1.affichage_des_poids();
			sac1.affichage_d_utilite();
			sac1.affichage_de_rapport();
			sac1.tri();
		   
		}
		
		
	}
