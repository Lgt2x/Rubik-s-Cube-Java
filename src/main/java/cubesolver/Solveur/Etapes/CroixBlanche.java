package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

/**
 * Etape de résolution #1
 * Place la croix de la première face
 */
public class CroixBlanche extends EtapeResolution {
    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();

        String mouvement = "FLBRF";
        /*
        on remarque que les pièces de la croix blanche sont celles avec le down soit les aretes du tableau 4 à 7 d'ou les for de 4 à 8
         */

        int j;
        char faceEtudiee;
        boolean libre;

        //setUp des aretes blanches
        for (int i = 4; i < 8; i++) {
            if (!Cube.aretes[i].appartientFace('U')&& !Cube.aretes[i].estPositionneeCorrectement()) {

                //trouver la face ou se trouve la pièce
                j = 0;
                while (!Cube.aretes[i].appartientFace(mouvement.charAt(j))) {
                    j++;
                }
                faceEtudiee = mouvement.charAt(j);

                /* Liberer l'emplacement pour insérer notre pièce blanche
                On verifie si les 4 pieces blanches ne sont pas à l'endroit que nous allons bouger,
                sinon mouvement U(haut) et on recommence l'opération */
                j = 4;
                while (j < 8) {
                    libre = !(Cube.aretes[j].appartientFace('U') && Cube.aretes[j].appartientFace(faceEtudiee));
                    if (!libre && i != j) {
                        mouvements.append("U");
                        Cube.mouvement('U');
                        j = 3;
                    }
                    j++;
                }

                // Placer notre pièce blanche
                while (!Cube.aretes[i].appartientFace('U')) {
                    mouvements.append(faceEtudiee);
                    Cube.mouvement(faceEtudiee);
                }
            }
        }

        int compteur = 0;
        //placer la face blanche en l'orientant
        for(int i=4; i<8; i++){
            if(Cube.aretes[i].estPositionneeCorrectement()){
                compteur++;
            }
        }

        while(compteur != 4){

            for(int i=4; i<8; i++){
                if(Cube.aretes[i].appartientFace('U')){
                    if(Cube.aretes[i].facelettes[0].face == 'U' && Cube.aretes[i].appartientFace(Cube.aretes[i].facelettes[1].color)){
                        String formula = Character.toString(Cube.aretes[i].facelettes[1].color) + Cube.aretes[i].facelettes[1].color;
                        mouvements.append(formula);
                        Cube.formule(formula);
                        compteur++;
                    }else if(Cube.aretes[i].facelettes[1].face == 'U' && Cube.aretes[i].appartientFace(mouvement.charAt(mouvement.indexOf(Cube.aretes[i].facelettes[1].color)+1))){
                        String mouv1 = Character.toString(Cube.aretes[i].facelettes[0].face);
                        mouvements.append(mouv1);
                        Cube.formule(mouv1);

                        String mouv2 = Character.toString(Cube.aretes[i].facelettes[1].face).toLowerCase();
                        mouvements.append(mouv2);
                        Cube.formule(mouv2);

                        mouv1 = mouv1.toLowerCase();
                        mouvements.append(mouv1);
                        Cube.formule(mouv1);

                        compteur++;
                    }
                }
            }
            mouvements.append('U');
            Cube.mouvement('U');

        }
        return mouvements.toString();
    }
}
