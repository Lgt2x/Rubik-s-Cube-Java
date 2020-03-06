package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class AnglesBlancs extends EtapeResolution {

    @Override
    public String effectuerEtape(){
        StringBuilder mouvements = new StringBuilder();

        int j;
        String mouvement = "RFLBR";
        String A;
        String a;
        String U = "U";
        String u = "u";
        String D = "D";
        String d = "d";
        
        // Pour chaque angle du Cube, on remarque que les angles de la face du bas sont ceux allant de 4 à 8
        for(int i=4; i<8; i++){

            // Si l'ange n'est pas en place
            if(!Cube.angles[i].estPositionneeCorrectement()){
                // Bouger l'angle pour qu'il soit simple à placer par la suite
                if(Cube.angles[i].facelettes[0].face == 'D' || Cube.angles[i].facelettes[0].face == 'U' ){
                    j = Math.min(mouvement.indexOf(Cube.angles[i].facelettes[1].face),mouvement.indexOf(Cube.angles[i].facelettes[2].face));
                }else if(Cube.angles[i].facelettes[1].face == 'D' || Cube.angles[i].facelettes[1].face == 'U'){
                    j = Math.min(mouvement.indexOf(Cube.angles[i].facelettes[0].face),mouvement.indexOf(Cube.angles[i].facelettes[2].face));
                }else{
                    j = Math.min(mouvement.indexOf(Cube.angles[i].facelettes[0].face),mouvement.indexOf(Cube.angles[i].facelettes[1].face));
                }

                if(j == 0){
                    if(Cube.angles[i].facelettes[0].face == 'B' || Cube.angles[i].facelettes[1].face == 'B' || Cube.angles[i].facelettes[2].face == 'B'){
                        j = 3;
                    }
                }

                A = ""+mouvement.charAt(j);
                a = A.toLowerCase();
                String mouvementsString = A+U+a+u;

                while(Cube.angles[i].appartientFace('D')){
                    Cube.formule(mouvementsString);
                    mouvements.append(mouvementsString);
                }

                // Mettre l'angle au dessus de sa position;
                while(!(Cube.angles[i].appartientFace(Cube.angles[i].facelettes[1].color) && Cube.angles[i].appartientFace(Cube.angles[i].facelettes[2].color))){
                    mouvements.append('U');
                    Cube.mouvement('U');
                }

                // Placer l'angle
                A = ""+mouvement.charAt(i-4);
                a = A.toLowerCase();
                mouvementsString = A+U+a+u;
                while(!Cube.angles[i].estPositionneeCorrectement()){
                    mouvements.append(mouvementsString);
                    Cube.formule(mouvementsString);
                }
            }
        }
        return mouvements.toString();
    }
}
