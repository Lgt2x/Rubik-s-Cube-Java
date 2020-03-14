package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

/**
 * Etape de résolution #2
 * Place et oriente les coins de la première face constituée, la face blanche
 * A la fin : la première couronne est en place
 */
public class AnglesBlancs extends EtapeResolution {

    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();

        int index;
        String mouvement = "RFLBR";

        // Pour chaque angle du Cube, on remarque que les angles de la face du bas sont ceux allant de 4 à 7
        for (int i = 4; i < 8; i++) {

            // Si l'ange n'est pas en place
            if (!Cube.angles[i].estPositionneeCorrectement()) {
                // Bouger l'angle pour qu'il soit simple à placer par la suite

                if (Cube.angles[i].facelettes[0].face == 'D'
                 || Cube.angles[i].facelettes[0].face == 'U') {
                    index = Math.min(
                            mouvement.indexOf(Cube.angles[i].facelettes[1].face),
                            mouvement.indexOf(Cube.angles[i].facelettes[2].face)
                    );
                } else if (Cube.angles[i].facelettes[1].face == 'D'
                        || Cube.angles[i].facelettes[1].face == 'U') {
                    index = Math.min(
                            mouvement.indexOf(Cube.angles[i].facelettes[0].face),
                            mouvement.indexOf(Cube.angles[i].facelettes[2].face)
                    );
                } else {
                    index = Math.min(
                            mouvement.indexOf(Cube.angles[i].facelettes[0].face),
                            mouvement.indexOf(Cube.angles[i].facelettes[1].face)
                    );
                }

                if (index == 0) {
                    if (Cube.angles[i].facelettes[0].face == 'B'
                            || Cube.angles[i].facelettes[1].face == 'B'
                            || Cube.angles[i].facelettes[2].face == 'B') {
                        index = 3;
                    }
                }

                // Construction du mouvement
                String mouvementsString = mouvement.charAt(index) + "U" + Character.toLowerCase(mouvement.charAt(index)) + "u";

                while (Cube.angles[i].appartientFace('D')) {
                    Cube.formule(mouvementsString);
                    mouvements.append(mouvementsString);
                }

                // Mettre l'angle au dessus de sa position;
                while (!(Cube.angles[i].appartientFace(Cube.angles[i].facelettes[1].color)
                        && Cube.angles[i].appartientFace(Cube.angles[i].facelettes[2].color))) {
                    mouvements.append('U');
                    Cube.mouvement('U');
                }

                // Placer l'angle
                mouvementsString = mouvement.charAt(i - 4) + "U" + Character.toLowerCase(mouvement.charAt(i - 4)) + "u";
                while (!Cube.angles[i].estPositionneeCorrectement()) {
                    mouvements.append(mouvementsString);
                    Cube.formule(mouvementsString);
                }
            }
        }

        return mouvements.toString();
    }
}
