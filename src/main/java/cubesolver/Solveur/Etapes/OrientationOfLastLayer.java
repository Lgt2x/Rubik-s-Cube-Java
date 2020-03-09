package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;
import java.util.HashMap;

public class OrientationOfLastLayer extends EtapeResolution {
    Long cas;

    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();
        
        cas = conversionLastLayer();
        boolean estResolu = false;

        // TODO : mettre tout ça dans un fichier...
        // Enregistrement de tous les cas d'oll avec leur formule respective

        HashMap<Long, String> oll = new HashMap();

        //All Edges Oriented Correctly
        oll.put(1001000001L, "RUUruRur"); //OCLL6
        oll.put(101000101000L, "RUUruRUruRur"); //OCLL1
        oll.put(1000100000L, "URURDruRdRR"); //OCLL4
        oll.put(101000000000L, "RRDrUURdrUUr"); //OCLL3
        oll.put(100000100100L, "RUrURUUr"); //OCLL7
        oll.put(100101001000L, "RUURRuRRuRRUUR"); //OCLL2
        oll.put(1000000100L, "URRDrURdrur"); //OCLL5

        //T-Shapes
        oll.put(11000110000L, "RUrurFRf"); //T1
        oll.put(10101010000L, "FRUruf"); //T2

        // Squares
        oll.put(110110100L, "UUrFFLFlFR"); //S1
        oll.put(11011000001L, "LFFrfRfl"); //S2

        //C-Shapes
        oll.put(10001010100L, "RURRurFRURuf"); //C1
        oll.put(10000111L, "rurFRfUR"); //C2

        //W-Shapes
        oll.put(1000010110L, "UURUrfRUrurFRurFRf"); //W1
        oll.put(10000100011L, "RUrURururFRf"); //W2

        //Corner Correct, Edges Flipped
        oll.put(10000000010L, "LFrfRlURur"); //E1
        oll.put(10000010000L, "RUruLrFRfl"); //E2

        //P-Shapes
        oll.put(11010100000L, "ruFURurfR"); //P1
        oll.put(10111L, "UrufUFR"); //P3
        oll.put(1010110000L, "RUburURBr"); //P2
        oll.put(111010000L, "UUFURurf"); //P4

        //I-Shapes
        oll.put(110101011000L, "UUFURurURurf"); //I1
        oll.put(10101010101L, "lbLurURurURlBL"); //I4
        oll.put(1010100111L, "RUrURuBubr"); //I2
        oll.put(111000111L, "UrFRURuRRfRRurURUr"); //I3

        //Fish Shapes
        oll.put(11001001010L, "RUrurFRRUruf");//F1
        oll.put(1010010100L, "RUURRFRfRUUr");//F3
        oll.put(100100110010L, "RUrUrFRfRUUr");//F2
        oll.put(11000000110L, "FRuruRUrf");//F4

        //Knight Move Shapes
        oll.put(110000110100L, "FURuRRfRURur"); //K1
        oll.put(11001011000L, "rFRUrfRFuf"); //K2
        oll.put(10100110100L, "lbLruRUlBL"); //K3
        oll.put(11001010001L, "UURBrLUluRbr"); //K4

        //Awkward Shapes
        oll.put(100010011L, "URUruRurfuFRUr"); //A1
        oll.put(110010001000L, "uFURUUruRUUruf"); //A2
        oll.put(10000101010L, "RUrURuurFRUruf"); //A3
        oll.put(101000010010L, "ruRurUURFRUruf"); //A4

        //L-Shapes
        oll.put(110101001010L, "FRUruRUruf"); //L2
        oll.put(11010100101L, "fluLUluLUF"); //L1
        oll.put(110111001000L, "ulUULUlULfluLUF"); //L3
        oll.put(100111011000L, "uRUUruRurFRUruf"); //L4
        oll.put(111010101L, "urfLflFLflFFR"); //L5
        oll.put(10111000101L, "LFrFRfrFRFFl"); //L6

        //Lightning Bolts
        oll.put(110000100110L, "LFrFRFFl"); //B1
        oll.put(1000011011L, "UUrfLflFFR"); //B2
        oll.put(100010110100L, "lRRBrBRBBrBrL"); //B3
        oll.put(11010001001L, "UFRUrufUFRUruf"); //B4
        oll.put(10000110001L, "LfluLUFul"); //B5
        oll.put(10100011000L, "rFRUrufUR"); //B6

        //No Edges Flipped Correctly
        oll.put(10111010111L, "RuurrFRfuurFRf"); //O1
        oll.put(110111011010L, "FRUrufUUFURurf"); //O2
        oll.put(10110110110L, "FRUrufufulULF"); //O3
        oll.put(11011010011L, "UFRUrufUURUrURururFRf"); //O4
        oll.put(111010010010L, "UUFRUrufurfLflFFR"); //O6
        oll.put(10110010011L, "UUFRUrufuRUrfRUrurFRurFRf"); //O7
        oll.put(10110011010L, "RUrUrFRfuurFRf"); //O5
        oll.put(10010010010L, "FURurfUUrurFRfUR"); //O8

        do {
            // Si notre cas est connu : resoudre, sinon faire tourner la face du haut jusqu'à tomber dessus
            if(oll.containsKey(cas)) {
                Cube.formule(oll.get(cas));
                mouvements.append(oll.get(cas));
                estResolu = true;
            }else{
                Cube.mouvement('U');
                mouvements.append('U');
                cas = conversionLastLayer();
            }
        } while(!estResolu);

        return mouvements.toString();
    }

    public Long conversionLastLayer() {
        // l'objectif de cette methode est de convertir le cube en un long afin de connaitre l'orientation des pieces du dernier etage our resoudre la face avec une unique formule
        long a = 0L;
        long coef = 1L;
        String voisins = "RBLFR";

        HashMap<Character, Integer> correspondance = new HashMap<>();
        correspondance.put('U', 0);
        correspondance.put('R', 1);
        correspondance.put('B', 4);
        correspondance.put('L', 7);
        correspondance.put('D', 10);
        correspondance.put('F', 10);

        // Les aretes jaune vont de 0 à 3
        for(int i = 0; i<4; i++){
            a+=(long)(Math.pow(10,correspondance.get(Cube.aretes[i].facelettes[0].face)));
            if(Cube.aretes[i].facelettes[0].face == 'U'){
                a-=1; // On ne veut rien ajouter quand c'est U
            }
        }
        for(int i = 0; i<4; i++){
            coef = 1L;
            if(Cube.angles[i].facelettes[0].face != 'U'){
                int j = 0;
                while(Cube.angles[i].facelettes[0].face != voisins.charAt(j)){
                    j++;
                }

                coef = (long)(Math.pow(10,3*j));

                if(Cube.angles[i].appartientFace(voisins.charAt(j+1))){
                    coef *=100L;
                }
                a+=coef;
            }
        }
        return a;
    }
}
