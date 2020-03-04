package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class CroixBlanche extends EtapeResolution {
    String mouvement = "FLBRF";

    @Override
    public ArrayList<Character> effectuerEtape(Cube cube){
        ArrayList<Character> mouvements = new ArrayList<>();

        /*
        on remarque que les pièces de la croix blanche sont celles avec le down soit les aretes du tableau 4 à 7 d'ou les for de 4 à 8
         */

        int j;
        int k = 4;
        char faceEtudiee;
        boolean libre;

        //placement des aretes blanches
        for(int i = 4; i<8; i++) {
            if(!cube.aretes[i].appartientFace('D')){

                //trouver la face ou se trouve la pièce
                j = 0;
                while(!cube.aretes[i].appartientFace(mouvement.charAt(j))){
                    j++;
                }
                faceEtudiee = mouvement.charAt(j);
                /*
                liberer l'emplacement pour incerer notre pièce blanche
                on verifie si les 4 pieces blanches sont bien ailleur que l'endroit que nous allons bouger,
                sinon mouvement D et on recommence l'opération
                */
                j = 4;
                libre = true;
                while(j<8){

                    libre = !(cube.aretes[j].appartientFace('D') && cube.aretes[j].appartientFace(faceEtudiee));
                    if(!libre && i!=j){
                        mouvements.add('D');
                        cube.mouvement('D');
                        j = 3;
                    }
                    j++;
                }

                //placer notre pièce blanche
                while(!cube.aretes[i].appartientFace('D')){
                   mouvements.add(faceEtudiee);
                   cube.mouvement(faceEtudiee);
                }
            }
        }

        //orienter la croix blanche
        for(int i = 4; i<8; i++){
            if(!cube.aretes[i].estOrienteCorrectement()){
                char M = cube.aretes[i].facelettes[0].face;
                String formula = ""+M+'d'+mouvement.charAt(mouvement.indexOf(M)+1);

                for(int z=0; z<formula.length(); z++){
                    mouvements.add(formula.charAt(z));
                }
                cube.formule(formula);
            }
        }

        //placer les aretes de la croix blanche
            //setUp
        for(int i = 4; i<8; i++){
            if(!cube.aretes[i].estPositionneeCorrectement()){
                String formula = ""+cube.aretes[i].facelettes[1].face+cube.aretes[i].facelettes[1].face;
                for(int z=0; z<formula.length(); z++){
                    mouvements.add(formula.charAt(z));
                }
                cube.formule(formula);
            }
        }
            //placement
        for(int i = 4; i<8; i++){
            if(!cube.aretes[i].appartientFace('D')) {
                while (!cube.aretes[i].appartientFace(cube.aretes[i].facelettes[1].color)) {
                    mouvements.add('U');
                    cube.mouvement('U');
                }
                String formula = ""+cube.aretes[i].facelettes[1].face + cube.aretes[i].facelettes[1].face;
                for(int z=0; z<formula.length(); z++){
                    mouvements.add(formula.charAt(z));
                }
                cube.formule(formula);
            }
        }
        return mouvements;
    }
}
