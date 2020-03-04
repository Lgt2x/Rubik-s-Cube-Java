package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;
import java.util.HashMap;

public class OrientationOfLastLayer extends EtapeResolution {
    Long cas;

    @Override
    public ArrayList<Character> effectuerEtape(Cube cube) {
        ArrayList<Character> mouvements = new ArrayList<>();
        
        cas = conversionLastLayer(cube);
        boolean estResolu = false;

        //enregister tous les cas d'oll avec leur formule respective
        HashMap<Long, String> oll = new HashMap();

        //All Edges Oriented Correctly
        oll.put(001001000001L, "RUUruRur"); //OCLL6
        oll.put(101000101000L, "RUUruRUruRur"); //OCLL1
        oll.put(001000100000L, "URURDruRdRR"); //OCLL4
        oll.put(101000000000L, "RRDrUURdrUUr"); //OCLL3
        oll.put(100000100100L, "RUrURUUr"); //OCLL7
        oll.put(100101001000L, "RUURRuRRuRRUUR"); //OCLL2
        oll.put(001000000100L, "URRDrURdrur"); //OCLL5

        //T-Shapes
        oll.put(011000110000L, "RUrurFRf"); //T1
        oll.put(010101010000L, "FRUruf"); //T2

        // Squares
        oll.put(000110110100L, "UUrFFLFlFR"); //S1
        oll.put(011011000001L, "LFFrfRFl"); //S2

        //C-Shapes
        oll.put(010001010100L, "RURRurFRURuf"); //C1
        oll.put(000010000111L, "rurFRfUR"); //C2

        //W-Shapes
        oll.put(001000010110L, "UURUrfRUrurFRurFRf"); //W1
        oll.put(010000100011L, "RUrURururFRf"); //W2

        //Corner Correct, Edges Flipped
        oll.put(010000000010L, "LFrfRlURur"); //E1
        oll.put(010000010000L, "RUruLrFRfl"); //E2

        //P-Shapes
        oll.put(011010100000L, "ruFURurfR"); //P1
        oll.put(000000010111L, "UrufUFR"); //P3
        oll.put(001010110000L, "RUburURBr"); //P2
        oll.put(000111010000L, "UUFURurf"); //P4

        //I-Shapes
        oll.put(110101011000L, "UUFURurURurf"); //I1
        oll.put(010101010101L, "lbLurURurURlBL"); //I4
        oll.put(001010100111L, "RUrURuBubr"); //I2
        oll.put(000111000111L, "UrFRURuRRfRRurURUr"); //I3

        //Fish Shapes
        oll.put(011001001010L, "RUrurFRRUruf");//F1
        oll.put(001010010100L, "RUURRFRfRUUr");//F3
        oll.put(100100110010L, "RUrUrFRfRUUr");//F2
        oll.put(011000000110L, "FRuruRUrf");//F4

        //Knight Move Shapes
        oll.put(011001001010L, "RUrurFRRUruf"); //F1
        oll.put(100100110010L, "RUrUrFRfRuur"); //F2
        oll.put(001010010100L, "RuurrFRfRuur"); //F3
        oll.put(011000000110L, "FRuruRUrf"); //F4

        //Awkward Shapes
        oll.put(000100010011L, "URUruRurfuFRUr"); //A1
        oll.put(110010001000L, "uFURUUruRUUruf"); //A2
        oll.put(010000101010L, "RUrURuurFRUruf"); //A3
        oll.put(101000010010L, "ruRurUURFRUruf"); //A4

        //L-Shapes
        oll.put(110101001010L, "FRUruRUruf"); //L2
        oll.put(011010100101L, "fluLUluLUF"); //L1
        oll.put(110111001000L, "ulUULUlUfluLUF"); //L3
        oll.put(100111011000L, "uRUUruRurFRUruf"); //L4
        oll.put(000111010101L, "rfLflFLflFFR"); //L5
        oll.put(010111000101L, "LFrFRfrFRFFl"); //L6

        //Lightning Bolts
        oll.put(110000100110L, "LFrFRFFl"); //B1
        oll.put(001000011011L, "UUrfLflFFR"); //B2
        oll.put(100010110100L, "lRRBrBRBBrBrL"); //B3
        oll.put(011010001001L, "UFRUrufUFRUruf"); //B4
        oll.put(010000110001L, "LfluLUFul"); //B5
        oll.put(010100011000L, "rFRUrufUR"); //B6

        //No Edges Flipped Correctly
        oll.put(010111010111L, "RuurrFRfuurFRf"); //O1
        oll.put(110111011010L, "FRUrufUUFURurf"); //O2
        oll.put(010110110110L, "FRUrufufulULF"); //O3
        oll.put(011011010011L, "UFRUrufUURUrURururFRf"); //O4
        oll.put(111010010010L, "UUFRUrufurfLflFFR"); //O6
        oll.put(010110010011L, "UUFRUrufuRUrfRUrurFRurFRf"); //O7
        oll.put(010110011010L, "RUrUrFRfuurFRf"); //O5
        oll.put(010010010010L, "FURurfUUrurFRfUR"); //O8

        do {
            //si notre cas est connu resoudre, sinon faire tourner la face du haut jusqu'à tomber dessus
            if(oll.containsKey(cas)) {
                cube.formule(oll.get(cas));
                estResolu = true;
            }else{
                mouvements.add('U');
            }
        } while(!estResolu);

        return mouvements;
    }

    public Long conversionLastLayer(Cube cube) {
        // l'objectif de cette methode est de convertir le cube en un long afin de connaitre l'orientation des pieces du dernier etage our resoudre la face avec une unique formule
        long a = 0L;
        long coef = 1L;
        String voisins = "FLBR";
        // les aretes jaune vont de 0 à 3, soit la boucle for :
        for(int i = 0; i<4; i++){
            if(cube.aretes[i].facelettes[0].face == 'U'){
                // ne rien faire
            }else if(cube.aretes[i].facelettes[0].face == 'F'){
                a+=10L;
            }else if(cube.aretes[i].facelettes[0].face == 'L'){
                a+=10000L;
            }else if(cube.aretes[i].facelettes[0].face == 'B'){
                a+=10000000L;
            }else{
                a+=10000000000L;
            }
        }
        for(int i = 0; i<4; i++){
            if(cube.angles[i].facelettes[0].face == 'U'){
                //ne rien faire
            } else{
                int j = 0;
                while(cube.angles[i].facelettes[0].face != voisins.charAt(j)){
                    j++;
                }
                coef = (j+1)*1000L;
                if(cube.angles[i].appartientFace(voisins.charAt(j+1))){
                    coef *=100L;
                }
                a+=coef;
            }
        }
        return a;
    }
}
