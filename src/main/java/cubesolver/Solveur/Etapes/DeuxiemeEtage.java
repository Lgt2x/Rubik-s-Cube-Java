package cubesolver.Solveur.Etapes;


import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class DeuxiemeEtage extends EtapeResolution {
        String mouvement = "RFLBR";
        String formula;
        String A;
        String a;
        String B;
        String b;
        String U = "U";
        String u = "u";

        @Override
        public ArrayList<Character> effectuerEtape(Cube cube){
            ArrayList<Character> mouvements = new ArrayList<>();
            
            /*
            les angles du deuxieme etage sont ceux allant de 8 à 12
             */
            for(int i = 8; i<12; i++){
                //verifier si la pièce est deja positionée
                if(!cube.aretes[i].estPositionneeCorrectement()){
                    //si elle n'est pas sur la face du haut, faire la formule afin de le mettre sur la face du haut
                    if(!cube.aretes[i].appartientFace('U')){
                    /*
                    TODO : sortir une pièce qui n'est pas sur la face du haut
                     */
                    }
                    //enregistrer la facelette qui est sur le dessus du cube
                    int o = 0;
                    if(cube.aretes[i].facelettes[1].face == 'U'){
                        o = 1;
                    }
                    A = String.valueOf(cube.aretes[i].facelettes[o].color);
                    a = A.toLowerCase();
                    B = String.valueOf(cube.aretes[i].facelettes[(o+1)%2].color);
                    b = B.toLowerCase();

                    //mettre la pièce en position
                    while(cube.aretes[i].facelettes[o].face != cube.aretes[i].facelettes[o].color ){
                        mouvements.add('U');
                    }

                    //formule pour placer la pièce
                    formula = U+B+u+b+u+a+U+A;
                    if(mouvement.indexOf(a)<mouvement.indexOf(b)){
                        cube.formule(formula);
                    }else{
                        cube.formuleSymetrique(formula);
                    }
                }
            }
            return mouvements;
        }
    }
