package cubesolver.Solveur;

import cubesolver.Cube.Cube;

import java.util.HashMap;

public class OrientationOfLastLayer {
    int[][] cas = new int[4][3];
    Cube cube = new Cube();
    public OrientationOfLastLayer() {
        int[][] t = new int[4][3];

        HashMap<int[][], String> oll = new HashMap();

        //All Edges Oriented Correctly
        oll.put(new int[][] {{0,0,1},{0,0,1},{0,0,0},{0,0,1}}, "RUUruRur"); //OCLL6
        oll.put(new int[][] {{1,0,1},{0,0,0},{1,0,1},{0,0,0}}, "RUUruRUruRur"); //OCLL1
        oll.put(new int[][] {{0,0,1},{0,0,0},{1,0,0},{0,0,0}}, ""); //OCLL4
        oll.put(new int[][] {{1,0,1},{0,0,0},{0,0,0},{0,0,0}}, "RRDrUURdrUUr"); //OCLL3
        oll.put(new int[][] {{1,0,0},{0,0,0},{1,0,0},{1,0,0}}, "RUrURUUr"); //OCLL7
        oll.put(new int[][] {{1,0,0},{1,0,1},{0,0,1},{0,0,0}}, "RUURRuRRuRRUUR"); //OCLL2
        oll.put(new int[][] {{0,0,1},{0,0,0},{0,0,0},{1,0,0}}, ""); //OCLL5

        //T-Shapes
        oll.put(new int[][] {{0,1,1},{0,0,0},{1,1,0},{0,0,0}}, "RUrurFRf"); //T1
        oll.put(new int[][] {{0,1,0},{1,0,1},{0,1,0},{0,0,0}}, "FRUruf"); //T2

        // Squares
        oll.put(new int[][] {{0,0,0},{1,1,0},{1,1,0},{1,0,0}}, ""); //S1
        oll.put(new int[][] {{0,1,1},{0,1,1},{0,0,0},{0,0,1}}, ""); //S2

        //C-Shapes
        oll.put(new int[][] {{0,1,0},{0,0,1},{0,1,0},{1,0,0}}, "RURRurFRURuf"); //C1
        oll.put(new int[][] {{0,0,0},{0,1,0},{0,0,0},{1,1,1}}, "rurFRfUR"); //C2

        //W-Shapes
        oll.put(new int[][] {{0,0,1},{0,0,0},{0,1,0},{1,1,0}}, "UURUrfRUrurFRurFRf"); //W1
        oll.put(new int[][] {{0,1,0},{0,0,0},{1,0,0},{0,1,1}}, "RUrURururFRf"); //W2

        //Corner Correct, Edges Flipped
        oll.put(new int[][] {{0,1,0},{0,0,0},{0,0,0},{0,1,0}}, ""); //E1
        oll.put(new int[][] {{0,1,0},{0,0,0},{0,1,0},{0,0,0}}, ""); //E2

        //P-Shapes
        oll.put(new int[][] {{0,1,1},{0,1,0},{1,0,0},{0,0,0}}, "ruFURurfR"); //P1
        oll.put(new int[][] {{0,0,0},{0,0,0},{0,1,0},{1,1,1}}, "UrufUFR"); //P3
        oll.put(new int[][] {{0,0,1},{0,1,0},{1,1,0},{0,0,0}}, "RUburURBr"); //P2
        oll.put(new int[][] {{0,0,0},{1,1,1},{0,1,0},{0,0,0}}, "UUFURurf"); //P4

        //I-Shapes
        oll.put(new int[][] {{1,1,0},{1,0,1},{0,1,1},{0,0,0}}, ""); //I1
        oll.put(new int[][] {{0,1,0},{1,0,1},{0,1,0},{1,0,1}}, ""); //I4
        oll.put(new int[][] {{0,0,1},{0,1,0},{1,0,0},{1,1,1}}, ""); //I2
        oll.put(new int[][] {{0,0,0},{1,1,1},{0,0,0},{1,1,1}}, ""); //I3

        //Knight Move Shapes
        oll.put(new int[][] {{0,1,1},{0,0,1},{0,0,1},{0,1,0}}, "RUrurFRRUruf"); //F1
        oll.put(new int[][] {{1,0,0},{1,0,0},{1,1,0},{0,1,0}}, "RUrUrFRfRuur"); //F2
        oll.put(new int[][] {{0,0,1},{0,1,0},{0,1,0},{1,0,0}}, "RuurrFRfRuur"); //F3
        oll.put(new int[][] {{0,1,1},{0,0,0},{0,0,0},{1,1,0}}, "FRuruRUrf"); //F4

        //Awkward Shapes
        oll.put(new int[][] {{0,0,0},{1,0,0},{0,1,0},{0,1,1}}, ""); //A1
        oll.put(new int[][] {{1,1,0},{0,1,0},{0,0,1},{0,0,0}}, ""); //A2
        oll.put(new int[][] {{0,1,0},{0,0,0},{1,0,1},{0,1,0}}, "RUrURuurFRUruf"); //A3
        oll.put(new int[][] {{1,0,1},{0,0,0},{0,1,0},{0,1,0}}, "ruRurUURFRUruf"); //A4

        //L-Shapes
        oll.put(new int[][] {{1,1,0},{1,0,1},{0,0,1},{0,1,0}}, "FRUruRUruf"); //L2
        oll.put(new int[][] {{0,1,1},{0,1,0},{1,0,0},{1,0,1}}, "fluLUluLUF"); //L1
        oll.put(new int[][] {{1,1,0},{1,1,1},{0,0,1},{0,0,0}}, ""); //L3
        oll.put(new int[][] {{1,0,0},{1,1,1},{0,1,1},{0,0,0}}, ""); //L4
        oll.put(new int[][] {{0,0,0},{1,1,1},{0,1,0},{1,0,1}}, ""); //L5
        oll.put(new int[][] {{0,1,0},{1,1,1},{0,0,0},{1,0,1}}, ""); //L6

        //Lightning Bolts
        oll.put(new int[][] {{1,1,0},{0,0,0},{1,0,0},{1,1,0}}, ""); //B1
        oll.put(new int[][] {{0,0,1},{0,0,0},{0,1,1},{0,1,1}}, ""); //B2
        oll.put(new int[][] {{1,0,0},{0,1,0},{1,1,0},{1,0,0}}, ""); //B3
        oll.put(new int[][] {{0,1,1},{0,1,0},{0,0,1},{0,0,1}}, ""); //B4
        oll.put(new int[][] {{0,1,0},{0,0,0},{1,1,0},{0,0,1}}, "LfluLUFul"); //B5
        oll.put(new int[][] {{0,1,0},{1,0,0},{0,1,1},{0,0,0}}, "rFRUrufUR"); //B6

        //No Edges Flipped Correctly
        oll.put(new int[][] {{0,1,0},{1,1,1},{0,1,0},{1,1,1}}, "RuurrFRfuurFRf"); //O1
        oll.put(new int[][] {{1,1,0},{1,1,1},{0,1,1},{0,1,0}}, ""); //O2
        oll.put(new int[][] {{0,1,0},{1,1,0},{1,1,0},{1,1,0}}, ""); //O3
        oll.put(new int[][] {{0,1,1},{0,1,1},{0,1,0},{0,1,1}}, ""); //O4
        oll.put(new int[][] {{1,1,1},{0,1,0},{0,1,0},{0,1,0}}, ""); //O6
        oll.put(new int[][] {{0,1,0},{1,1,0},{0,1,0},{0,1,1}}, ""); //O7
        oll.put(new int[][] {{0,1,0},{1,1,0},{0,1,1},{0,1,0}}, "RUrUrFRfuurFRf"); //O5
        oll.put(new int[][] {{0,1,0},{0,1,0},{0,1,0},{0,1,0}}, ""); //O8

        do {

            cube.mouvement('U');
        }while(!estResolu(this.cas));



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
