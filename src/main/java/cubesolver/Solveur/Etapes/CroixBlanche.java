package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

public class CroixBlanche extends EtapeResolution {
    @Override
    public String effectuerEtape(){
        StringBuilder mouvements = new StringBuilder();
        String mouvement = "FLBRF";
        /*
        on remarque que les pièces de la croix blanche sont celles avec le down soit les aretes du tableau 4 à 7 d'ou les for de 4 à 8
         */

        int j;
        int k = 4;
        char faceEtudiee;
        boolean libre;

        //placement des aretes blanches
        for(int i = 4; i<8; i++) {
            if(!Cube.aretes[i].appartientFace('D')){

                //trouver la face ou se trouve la pièce
                j = 0;
                while(!Cube.aretes[i].appartientFace(mouvement.charAt(j))){
                    j++;
                }
                faceEtudiee = mouvement.charAt(j);
                /*
                liberer l'emplacement pour incerer notre pièce blanche
                on verifie si les 4 pieces blanches sont bien ailleur que l'endroit que nous allons bouger,
                sinon mouvement D et on recommence l'opération
                */
                j = 4;
                while(j<8){

                    libre = !(Cube.aretes[j].appartientFace('D') &&Cube.aretes[j].appartientFace(faceEtudiee));
                    if(!libre && i!=j){
                        mouvements.append("D");
                       Cube.mouvement('D');
                        j = 3;
                    }
                    j++;
                }

                //placer notre pièce blanche
                while(!Cube.aretes[i].appartientFace('D')){
                   mouvements.append(faceEtudiee);
                  Cube.mouvement(faceEtudiee);
                }
            }
        }

        //orienter la croix blanche
        for(int i = 4; i<8; i++){
            if(!Cube.aretes[i].estOrienteCorrectement()){
                char M =Cube.aretes[i].facelettes[0].face;
                String formula = ""+M+'d'+mouvement.charAt(mouvement.indexOf(M)+1);

                for(int z=0; z<formula.length(); z++){
                    mouvements.append(formula.charAt(z));
                }
               Cube.formule(formula);
            }
        }

        //placer les aretes de la croix blanche
            //setUp
        for(int i = 4; i<8; i++){
            if(!Cube.aretes[i].estPositionneeCorrectement()){
                String formula = ""+Cube.aretes[i].facelettes[1].face+Cube.aretes[i].facelettes[1].face;
                for(int z=0; z<formula.length(); z++){
                    mouvements.append(formula.charAt(z));
                }
               Cube.formule(formula);
            }
        }
            //placement
        for(int i = 4; i<8; i++){
            if(!Cube.aretes[i].appartientFace('D')) {
                while (!Cube.aretes[i].appartientFace(Cube.aretes[i].facelettes[1].color)) {
                    mouvements.append("U");
                   Cube.mouvement('U');
                }
                String formula = ""+Cube.aretes[i].facelettes[1].face +Cube.aretes[i].facelettes[1].face;
                for(int z=0; z<formula.length(); z++){
                    mouvements.append(formula.charAt(z));
                }
               Cube.formule(formula);
            }
        }
        return mouvements.toString();
    }
}
