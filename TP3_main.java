  import java.util.Scanner;
public class TP3_main {


    public static void main(String[] args) {
        
       
        //la lecture de poids max de sac a dos :
        System.out.print(" - Tapez le poids maximale de ce sac a dos: ");
        Scanner obj = new Scanner(System.in);
        
        int P_max = obj.nextInt();
        System.out.println();
        
        //l'initialisation de sac a dos :
        sac_a_dos sac = new sac_a_dos(P_max);

        // l'excution de la methode Branch & Bround:
        sac.Branch_Bround();
        
       // la solution :
         sac.AfficheSolution();

     
   }

}
