package cubesolver.Solveur;

import cubesolver.Cube.Cube;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class OrientationOfLastLayer {
    int[][] cas = new int[4][3];
    Cube cube = new Cube();
    public OrientationOfLastLayer() {
        int[][] t = new int[4][3];

        HashMap<Integer[][],String> map = new HashMap();


        do {


            //instanciation des cas
            int[][][] tab = cube.exportCube();
            for (int i = 0; i < cas[0].length; i++) {
                cas[0][i] = tab[1][0][2 - i];
            }
            for (int i = 0; i < cas[1].length; i++) {
                cas[1][i] = tab[2][i][2];
            }
            for (int i = 0; i < cas[2].length; i++) {
                cas[2][i] = tab[3][0][i];
            }
            for (int i = 0; i < cas[1].length; i++) {
                cas[3][i] = tab[4][i][0];
            }





            //comparaison des cas
            //t = {{0,0,1},{0,0,1},{0,0,0},{0,0,1}};
            if (comparateurCas(cas, new int[][] {{0,0,1},{0,0,1},{0,0,0},{0,0,1}}))
                cube.formule(""); //AEOC 1

            else if (comparateurCas(cas, {{1,0,0},{0,0,0},{1,0,0},{1,0,0}}))
                cube.formule("");//AEOC 2

            else if (comparateurCas(cas, {{1,0,1},{0,0,0},{1,0,1},{0,0,0}}))
                cube.formule("");//AEOC 3

            if(comparateurCas(cas, {{1,0,0},{1,0,1},{0,0,1},{0,0,0}}))
                cube.formule("");//AEOC 4

            if(comparateurCas(cas, {{0,0,1},{0,0,0},{1,0,0},{0,0,0}}))
                cube.formule("");//AEOC 5

            if(comparateurCas(cas, {{0,0,1},{0,0,0},{0,0,0},{1,0,0}}))
                cube.formule("");//AEOC 6

            if(comparateurCas(cas, {{1,0,1},{0,0,0},{0,0,0},{0,0,0}}))
                cube.formule("");//AEOC 7

            if(comparateurCas(cas, {{0,1,1},{0,0,0},{1,1,0},{0,0,0}}))
                cube.formule("");//T-Shape 1

            if(comparateurCas(cas, {{0,1,0},{1,0,1},{0,1,0},{0,0,0}}))
                cube.formule("");//T-Shape 2

            if(comparateurCas(cas, {{0,0,0},{1,1,0},{1,1,0},{1,0,0}}))
                cube.formule("");//Square 1

            if(comparateurCas(cas, {{0,1,1},{0,1,1},{0,0,0},{0,0,1}}))
                cube.formule("");//Square 2

            if(comparateurCas(cas, {{0,1,0},{0,0,1},{0,1,0},{1,0,0}}))
                cube.formule("");//C-Shape 1

            if(comparateurCas(cas, {{0,0,0},{0,1,0},{0,0,0},{1,1,1}}))
                cube.formule("");//C-Shape 2

            if(comparateurCas(cas, {{0,0,1},{0,0,0},{0,1,0},{1,1,0}}))
                cube.formule("");//W-Shape 1

            if(comparateurCas(cas, {{0,1,0},{0,0,0},{1,0,0},{0,1,1}}))
                cube.formule("");//W-Shape 2

            if(comparateurCas(cas, {{0,1,0},{0,0,0},{0,0,0},{0,1,0}}))
                cube.formule("");//CCEF 1

            if(comparateurCas(cas, {{0,1,0},{0,0,0},{0,1,0},{0,0,0}}))
                cube.formule("");//CCEF 2

            if(comparateurCas(cas, {{0,1,1},{0,1,0},{1,0,0},{0,0,0}}))
                cube.formule("");//P-Shape 1

            if(comparateurCas(cas, {{0,0,1},{0,1,0},{1,1,0},{0,0,0}}))
                cube.formule("");//P-Shape 2

            if(comparateurCas(cas, {{0,0,0},{0,0,0},{0,1,0},{1,1,1}}))
                cube.formule(""); //P-Shape 3

            if(comparateurCas(cas, {{0,0,0},{1,1,1},{0,1,0},{0,0,0}}))
                cube.formule(""); //P-Shape 4

            if (comparateurCas(cas, {{1,1,0},{1,0,1},{0,1,1},{0,0,0}}))
                cube.formule(""); //I-Shape 1

            if (comparateurCas(cas, {{0,1,0},{1,0,1},{0,1,0},{1,0,1}}))
                cube.formule(""); //I-Shape 2

            if (comparateurCas(cas, {{0,0,1},{0,1,0},{1,0,0},{1,1,1}}))
                cube.formule(""); //I-Shape 3

            if (comparateurCas(cas, {{0,0,0},{1,1,1},{0,0,0},{1,1,1}}))
                cube.formule(""); //I-Shape 4

            if (comparateurCas(cas, {{0,1,1},{0,0,1},{0,0,1},{0,1,0}}))
                cube.formule(""); //Fish Shape 1

            if (comparateurCas(cas, {{1,0,0},{1,0,0},{1,1,0},{0,1,0}}))
                cube.formule(""); //Fish Shape 2

            if (comparateurCas(cas, {{0,0,1},{0,1,0},{0,1,0},{1,0,0}}))
                cube.formule(""); //Fish Shape 3

            if (comparateurCas(cas, {{0,1,1},{0,0,0},{0,0,0},{1,1,0}}))
                cube.formule(""); //Fish Shape 4

            if (comparateurCas(cas, {{1,1,0},{0,0,0},{1,1,0},{1,0,0}}))
                cube.formule(""); //Knight Move Shape 1

            if (comparateurCas(cas, {{0,1,1},{0,0,1},{0,1,1},{0,0,0}}))
                cube.formule(""); //Knight Move Shape 2

            if (comparateurCas(cas, {{0,1,1},{0,0,1},{0,1,0},{0,0,1}}))
                cube.formule(""); //Knight Move Shape 3

            if (comparateurCas(cas, {{0,1,0},{1,0,0},{1,1,0},{1,0,0}}))
                cube.formule(""); //Knight Move Shape 4

            if (comparateurCas(cas, {{0,0,0},{1,0,0},{0,1,0},{0,1,1}}))
                cube.formule(""); //Awkward Shape 1

            if (comparateurCas(cas, {{1,1,0},{0,1,0},{0,0,1},{0,0,0}}))
                cube.formule(""); //Awkward Shape 2

            if (comparateurCas(cas, {{0,1,0},{0,0,0},{1,0,1},{0,1,0}}))
                cube.formule(""); //Awkward Shape 3

            if (comparateurCas(cas, {{1,0,1},{0,0,0},{0,1,0},{0,1,0}}))
                cube.formule(""); //Awkward Shape 4

            if (comparateurCas(cas, {{1,1,0},{1,0,1},{0,0,1},{0,1,0}}))
                cube.formule(""); //L-Shape 1

            if (comparateurCas(cas, {{0,1,1},{0,1,0},{1,0,0},{1,0,1}}))
                cube.formule(""); //L-Shape 2

            if (comparateurCas(cas, {{1,1,0},{1,1,1},{0,0,1},{0,0,0}}))
                cube.formule(""); //L-Shape 3

            if (comparateurCas(cas, {{1,0,0},{1,1,1},{0,1,1},{0,0,0}}))
                cube.formule(""); //L-Shape 4

            if (comparateurCas(cas, {{0,0,0},{1,1,1},{0,1,0},{1,0,1}}))
                cube.formule(""); //L-Shape 5

            if (comparateurCas(cas, {{0,1,0},{1,1,1},{0,0,0},{1,0,1}}))
                cube.formule(""); //L-Shape 6

            if (comparateurCas(cas, {{1,1,0},{0,0,0},{1,0,0},{1,1,0}}))
                cube.formule(""); //Lightning Bolt 1

            if (comparateurCas(cas, {{0,0,1},{0,0,0},{0,1,1},{0,1,1}}))
                cube.formule(""); //Lightning Bolt 2

            if (comparateurCas(cas, {{1,0,0},{0,1,0},{1,1,0},{1,0,0}}))
                cube.formule(""); //Lightning Bolt 3

            if (comparateurCas(cas, {{0,1,1},{0,1,0},{0,0,1},{0,0,1}}))
                cube.formule(""); //Lightning Bolt 4

            if (comparateurCas(cas, {{0,1,0},{0,0,0},{1,1,0},{0,0,1}}))
                cube.formule(""); //Lightning Bolt 5

            if (comparateurCas(cas, {{0,1,0},{1,0,0},{0,1,1},{0,0,0}}))
                cube.formule(""); //Lightning Bolt 6

            if (comparateurCas(cas, {{0,1,0},{1,1,1},{0,1,0},{1,1,1}}))
                cube.formule(""); //NEFC 1

            if (comparateurCas(cas, {{1,1,0},{1,1,1},{0,1,1},{0,1,0}}))
                cube.formule(""); //NEFC 2

            if (comparateurCas(cas, {{0,1,0},{1,1,0},{1,1,0},{1,1,0}}))
                cube.formule(""); //NEFC 3

            if (comparateurCas(cas, {{0,1,1},{0,1,1},{0,1,0},{0,1,1}}))
                cube.formule(""); //NEFC 4

            if (comparateurCas(cas, {{1,1,1},{0,1,0},{0,1,0},{0,1,0}}))
                cube.formule(""); //NEFC 5

            if (comparateurCas(cas, {{0,1,0},{1,1,0},{0,1,0},{0,1,1}}))
                cube.formule(""); //NEFC 6

            if (comparateurCas(cas, {{0,1,0},{1,1,0},{0,1,1},{0,1,0}}))
                cube.formule(""); //NEFC 7

            if (comparateurCas(cas, {{0,1,0},{0,1,0},{0,1,0},{0,1,0}}))
                cube.formule("");//NEFC 8





            cube.mouvement('U');
        }while(!estResolu(this.cas));



    }





    public boolean comparateurCas(int[][] cas, String solution){
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
        boolean estResolu = true;
        for(int i = 0; i<cas.length; i++){
            for(int j = 0; j<cas[0].length; j++) {
                if(cas[i][j] != 0){
                    estResolu = false;
                    break;
                }
            }
            if(!estResolu){
                break;
            }
        }
        return estResolu;
    }
}
