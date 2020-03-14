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

        //placement des aretes blanches
        for (int i = 4; i < 8; i++) {
            if (!Cube.aretes[i].appartientFace('D')) {

                //trouver la face ou se trouve la pièce
                j = 0;
                while (!Cube.aretes[i].appartientFace(mouvement.charAt(j))) {
                    j++;
                }
                faceEtudiee = mouvement.charAt(j);

                /* Liberer l'emplacement pour insérer notre pièce blanche
                On verifie si les 4 pieces blanches ne sont pas à l'endroit que nous allons bouger,
                sinon mouvement D (bas) et on recommence l'opération */
                j = 4;
                while (j < 8) {
                    libre = !(Cube.aretes[j].appartientFace('D') && Cube.aretes[j].appartientFace(faceEtudiee));
                    if (!libre && i != j) {
                        mouvements.append("D");
                        Cube.mouvement('D');
                        j = 3;
                    }
                    j++;
                }

                // Placer notre pièce blanche
                while (!Cube.aretes[i].appartientFace('D')) {
                    mouvements.append(faceEtudiee);
                    Cube.mouvement(faceEtudiee);
                }
            }
        }

        // Orienter la croix blanche
        for (int i = 4; i < 8; i++) {
            if (!Cube.aretes[i].estOrienteCorrectement()) {
                char face = Cube.aretes[i].facelettes[0].face;
                String formula = face + "d" + mouvement.charAt(mouvement.indexOf(face) + 1);
                mouvements.append(formula);
                Cube.formule(formula);
            }
        }

        // Placer les aretes de la croix blanche

        // Setup
        for (int i = 4; i < 8; i++) {
            if (!Cube.aretes[i].estPositionneeCorrectement()) {
                String formula = Character.toString(Cube.aretes[i].facelettes[1].face) + Cube.aretes[i].facelettes[1].face;
                mouvements.append(formula);
                Cube.formule(formula);
            }
        }

        // Placement
        for (int i = 4; i < 8; i++) {
            if (!Cube.aretes[i].appartientFace('D')) {
                while (!Cube.aretes[i].appartientFace(Cube.aretes[i].facelettes[1].color)) {
                    mouvements.append("U");
                    Cube.mouvement('U');
                }

                String formula = Character.toString(Cube.aretes[i].facelettes[1].face) + Cube.aretes[i].facelettes[1].face;
                mouvements.append(formula);
                Cube.formule(formula);
            }
        }

        return mouvements.toString();
    }
}
