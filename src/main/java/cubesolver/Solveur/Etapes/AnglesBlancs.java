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
    public ArrayList<Character> effectuerEtape(Cube cube){
        ArrayList<Character> mouvements = new ArrayList<>();

        /*
        pour chaque angles du cube, on remarque que les angles de la face du bas sont ceux allant de 4 à 8
         */
        for(int i=4; i<8; i++){
            //si l'ange n'est pas en place
            if(!cube.angles[i].estPositionneeCorrectement()){

                //bouger l'angle pour qu'il soit simple à placer par la suite
                char place;
                if(cube.angles[i].facelettes[1].face != 'D'){
                    place = cube.angles[i].facelettes[1].face;
                }else{
                    place = cube.angles[i].facelettes[0].face;
                }
                A = String.valueOf(place);
                a = A.toLowerCase();

                String mouvementsString = A+U+a;
                while(cube.angles[i].appartientFace('D') || cube.angles[i].estOrienteeSelon('U')){
                    cube.formule(mouvementsString);
                }

                //mettre l'angle au dessus de sa position;
                while(!cube.angles[i].appartientFace(cube.angles[i].facelettes[1].color) || !cube.angles[i].appartientFace(cube.angles[i].facelettes[2].color)){
                    mouvements.add('D');
                    cube.mouvement('U');
                }

                //placer l'angle
                A = String.valueOf(mouvement.charAt(i-4));
                a = A.toLowerCase();
                mouvementsString = A+U+a;
                while(!cube.angles[i].estPositionneeCorrectement()){

                    /**
                     * BOUCLE INFINIE ICI
                     */

                    cube.formule(mouvementsString);
                }
            }
        }

        return mouvements;
    }
}
