package cubesolver.Solveur;

import cubesolver.Cube.Cube;

import java.util.LinkedList;
import java.util.Queue;

public class OrientationOfLastLayer {
    int[][] cas = new int[4][3];
    Cube cube = new Cube();
    public OrientationOfLastLayer() {


       int [][][]tab = cube.exportCube();
       for(int i = 0; i<cas[0].length; i++){
           cas[0][i] = tab[1][0][2-i];
       }
       for(int i= 0; i<cas[1].length; i++){
           cas[1][i] = tab[2][i][2];
       }
        for(int i= 0; i<cas[2].length; i++){
            cas[2][i] = tab[3][0][i];
        }
        for(int i= 0; i<cas[1].length; i++){
            cas[3][i] = tab[4][i][0];
        }



    }





    public boolean comparateurCas(int[][] cas, int[][] solution){
        boolean estIdentique = true;
        for(int i = 0; i<solution.length; i++){
            for(int j = 0; j<solution[i].length; j++){
                if (cas[i][j] != solution[i][j]) {
                    estIdentique = false;
                    break;
                }
            }
            if(!estIdentique){
                break;
            }
        }
        return estIdentique;
    }

    public boolean estResolu(int[][] cas){
        for(int i = 0; i<cas[])
    }
}
