package cubesolver;

import cubesolver.Cube.*;
import cubesolver.IHM.GestionAffichage;

public class App{
    public static void main(String []args){
        GestionAffichage visualisation = new GestionAffichage();
        Cube cube = new Cube();
        cube.formule("Ur");

        //afficherCube(cube.exportCube());
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