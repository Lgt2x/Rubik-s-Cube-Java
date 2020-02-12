import IHM.GestionAffichage;
import IHM.*;
import IHM.Cube.*;


public class main{
    public static void main(String []args){
        //GestionAffichage visualisation = new GestionAffichage();
        System.out.println("coucou");
        Cube cube = new Cube();
        cube.mouvement("B", true);
        cube.mouvement("B", true);

        cube.mouvement("F", true);
        cube.mouvement("F", true);

        cube.mouvement("R", true);
        cube.mouvement("R", true);

        cube.mouvement("L", true);
        cube.mouvement("L", true);

        cube.mouvement("U", true);
        cube.mouvement("U", true);

        cube.mouvement("D", true);
        cube.mouvement("D", true);
        afficherCube(cube.exportCube());
    }

    public static void afficherCube(int[][][] cube){
        for(int i = 0; i<6; i++){
            for(int j = 0; j<3; j++){
                for(int k = 0; k<3; k++){
                    System.out.print(cube[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}