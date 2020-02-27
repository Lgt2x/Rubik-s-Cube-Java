package cubesolver.Solveur.etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

public class CroixBlanche extends EtapeResolution {
    String mouvement = "FLBRF";

    @Override
    public void effectuerEtape(Cube cube) {
/*
        on remarque que les pièces de la croix blanche sont celles avec le down soit les aretes du tableau 4 à 7 d'ou les for de 4 à 8
         */

        int j = 0;
        int k = 4;
        char faceEtudiee;
        boolean libre = true;

        //placement des aretes blanches
        for(int i = 4; i<8; i++) {
            if(!cube.aretes[i].appartientFace('D')){

                //trouver la face ou se trouve la pièce
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
                while(j<8 && libre){
                    libre = !(cube.aretes[k].appartientFace('D') && cube.aretes[j].appartientFace(faceEtudiee));
                    if(!libre){
                        cube.mouvement('D');
                        j = 4;
                    }
                    j++;
                }
                //placer notre pièce blanche
                while(!cube.aretes[i].appartientFace('D')){
                    cube.mouvement(faceEtudiee);
                }
            }
        }

        //orienter la croix blanche
        /*for(int i = 4; i<8; i++){
            if(!cube.aretes[i].estOriente()){
                char M = cube.aretes[i].facelettes[1].face;
                String formule = String.valueOf(M+'d'+ mouvement.charAt(mouvement.indexOf(M)+1));
                cube.formule(formule);
            }
        }

        //placer les aretes de la croix blanche
            //setUp
        for(int i = 4; i<8; i++){
            if(!cube.aretes[i].appartientFace(cube.aretes[i].facelettes[1].color)){
                String formule = String.valueOf(cube.aretes[i].facelettes[1].face+cube.aretes[i].facelettes[1].face);
                cube.formule(formule);
            }
        }
            //placement
        for(int i = 4; i<8; i++){
            if(!cube.aretes[i].appartientFace('D')) {
                while (!cube.aretes[i].appartientFace(cube.aretes[i].facelettes[1].color)) {
                    cube.mouvement('U');
                }
                String formule = String.valueOf(cube.aretes[i].facelettes[1].face + cube.aretes[i].facelettes[1].face);
                cube.formule(formule);
            }
        }*/
    }
}
