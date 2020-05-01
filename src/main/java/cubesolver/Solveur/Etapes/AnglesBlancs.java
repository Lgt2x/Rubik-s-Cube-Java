package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

/**
 * Etape de résolution #2
 * Place et oriente les coins de la première face constituée, la face blanche
 * A la fin : la première couronne est en place
 */
public class AnglesBlancs extends EtapeResolution {

    public static String formuleDroite(char c) {
        return c + "U" + Character.toLowerCase(c);
    }

    public static String formuleGauche(char c) {
        return Character.toLowerCase(c) + "u" + c;
    }

    public static String formuleHaut(char c) {
        return c + "UU" + Character.toLowerCase(c) + "u" + c + "U" + Character.toLowerCase(c);
    }

    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();

        int index;
        String mouvementsString;
        String mouvement = "RFLBRD";

        // Pour chaque angle du Cube, on remarque que les angles de la face du bas sont ceux allant de 4 à 7
        for (int i = 4; i < 8; i++) {

            // Si l'ange n'est pas en place
            if (!Cube.angles[i].estPositionneeCorrectement()) {

                // Sortir l'angle de la face du bas
                if (Cube.angles[i].appartientFace('D')) {
                    index = Math.min(
                            Math.min(
                                    mouvement.indexOf(Cube.angles[i].facelettes[0].face),
                                    mouvement.indexOf(Cube.angles[i].facelettes[1].face)),
                            mouvement.indexOf(Cube.angles[i].facelettes[2].face)
                    );


                    // Corriger l'erreur liée à la boucle
                    if (index == 0) {
                        if (Cube.angles[i].appartientFace('B')) {
                            index = 3;
                        }
                    }

                    // Sortir l'angle
                    mouvementsString = formuleDroite(mouvement.charAt(index));
                    Cube.formule(mouvementsString);
                    mouvements.append(mouvementsString);
                }

                // Mettre l'angle au dessus de sa position;
                while (!(Cube.angles[i].appartientFace(Cube.angles[i].facelettes[1].color)
                        && Cube.angles[i].appartientFace(Cube.angles[i].facelettes[2].color))) {
                    mouvements.append('U');
                    Cube.mouvement('U');
                }

                // Définir le min et le max pour faire la formule
                int min = Math.min(
                        mouvement.indexOf(Cube.angles[i].facelettes[1].color),
                        mouvement.indexOf(Cube.angles[i].facelettes[2].color));
                int max = Math.max(
                        mouvement.indexOf(Cube.angles[i].facelettes[1].color),
                        mouvement.indexOf(Cube.angles[i].facelettes[2].color));

                if (min == 0) {
                    if (Cube.angles[i].facelettes[0].face == 'B'
                            || Cube.angles[i].facelettes[1].face == 'B'
                            || Cube.angles[i].facelettes[2].face == 'B') {
                        min = 3;
                        max = 0;
                    }
                }

                // Placer l'angle
                if (Cube.angles[i].facelettes[0].face == 'U') {
                    mouvementsString = formuleHaut(mouvement.charAt(min));
                } else if (Cube.angles[i].facelettes[0].face == mouvement.charAt(min)) {
                    mouvementsString = formuleDroite(mouvement.charAt(min));
                } else {
                    mouvementsString = formuleGauche(mouvement.charAt(max));
                }

                Cube.formule(mouvementsString);
                mouvements.append(mouvementsString);
            }
        }

        return mouvements.toString();
    }


}
