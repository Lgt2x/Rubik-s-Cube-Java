package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class AnglesBlancs extends EtapeResolution {
    String mouvement = "RFLBR";
    String A;
    String a;
    String U = "U";
    String u = "u";
    String D = "D";
    String d = "d";

    @Override
    public String effectuerEtape(){
        StringBuilder mouvements = new StringBuilder();

        /*
        pour chaque angles du cube, on remarque que les angles de la face du bas sont ceux allant de 4 à 8
         */
        for(int i=4; i<8; i++){
            //si l'ange n'est pas en place
            if(!Cube.angles[i].estPositionneeCorrectement()){

                //bouger l'angle pour qu'il soit simple à placer par la suite
                char place;
                if(Cube.angles[i].facelettes[1].face != 'D'){
                    place =Cube.angles[i].facelettes[1].face;
                }else{
                    place =Cube.angles[i].facelettes[0].face;
                }
                A = String.valueOf(place);
                a = A.toLowerCase();

                String mouvementsString = A+U+a;
                while(Cube.angles[i].appartientFace('D') ||Cube.angles[i].estOrienteeSelon('U')){
                   Cube.formule(mouvementsString);
                }

                //mettre l'angle au dessus de sa position;
                while(!Cube.angles[i].appartientFace(Cube.angles[i].facelettes[1].color) || !Cube.angles[i].appartientFace(Cube.angles[i].facelettes[2].color)){
                    mouvements.append("D");
                   Cube.mouvement('U');
                }

                //placer l'angle
                A = String.valueOf(mouvement.charAt(i-4));
                a = A.toLowerCase();
                mouvementsString = A+U+a;
                while(!Cube.angles[i].estPositionneeCorrectement()){

                    /**
                     * BOUCLE INFINIE ICI
                     */

                   Cube.formule(mouvementsString);
                }
            }
        }

        return mouvements.toString();
    }
}
