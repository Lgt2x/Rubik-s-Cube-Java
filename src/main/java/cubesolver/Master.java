package cubesolver;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

public class Master {
    public Master() {
        Cube cube = new Cube();
        GestionAffichage visualisation = new GestionAffichage(cube);
        visualisation.actualise(cube.exportCube());
        cube.formule("RRLLDDUUBBFF");
        visualisation.actualise(cube.exportCube());
    }

    public static void affichageCLICube(int[][][] cube){
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
