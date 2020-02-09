import IHM.GestionAffichage;
import IHM.*;
import IHM.Cube.*;


public class main{
    public static void main(String []args){
        GestionAffichage visualisation = new GestionAffichage();

        Cube cube = new Cube();
        cube.mouvement('U');
    }
}