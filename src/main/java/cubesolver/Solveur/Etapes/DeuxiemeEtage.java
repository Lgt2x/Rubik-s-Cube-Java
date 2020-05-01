package cubesolver.Solveur.Etapes;


import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

/**
 * Etape de résolution #3
 * Place les arêtes du deuxième étape
 */
public class DeuxiemeEtage extends EtapeResolution {
    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();

        String ordreFaces = "RFLBR";
        String formule;
        int index;

        // Les angles du deuxieme etage sont ceux allant de 8 à 11
        for (int i = 8; i < 12; i++) {

            // Vérifier si la pièce est deja positionée
            if (!Cube.aretes[i].estPositionneeCorrectement()) {

                // Si elle n'est pas sur la face du haut, faire la formule afin de le mettre sur la face du haut
                if (!Cube.aretes[i].appartientFace('U')) {
                    index = Math.min(ordreFaces.indexOf(Cube.aretes[i].facelettes[0].face), ordreFaces.indexOf(Cube.aretes[i].facelettes[1].face));
                    if (index == 0) {
                        if (Cube.aretes[i].facelettes[0].face == 'B' || Cube.aretes[i].facelettes[1].face == 'B') {
                            index = 3;
                        }
                    }

                    formule = "U" + ordreFaces.charAt(index) + "u" + Character.toLowerCase(ordreFaces.charAt(index))
                            + "u" + Character.toLowerCase(ordreFaces.charAt(index + 1)) + "U" + ordreFaces.charAt(index + 1);
                    Cube.formule(formule);
                    for (int z = 0; z < formule.length(); z++) {
                        mouvements.append(formule.charAt(z));
                    }
                }

                // Enregistrer la facelette qui est sur le dessus du Cube
                // La face adjacente à pour valeur 0
                index = 1;
                if (Cube.aretes[i].facelettes[1].face == 'U') {
                    index = 0;
                }
                char A = Cube.aretes[i].facelettes[index].color;
                char a = Character.toLowerCase(A);
                char B = Cube.aretes[i].facelettes[(index + 1) % 2].color;
                char b = Character.toLowerCase(B);

                // Mettre la pièce en position
                while (Cube.aretes[i].facelettes[index].face != Cube.aretes[i].facelettes[index].color) {
                    mouvements.append('U');
                    Cube.mouvement('U');
                }


                // Formule pour placer la pièce
                if (A == 'R' && B == 'B') {
                    formule = "U" + B + "u" + b + "u" + a + "U" + A;
                    Cube.formule(formule);
                    mouvements.append(formule);
                } else if (A == 'B' && B == 'R') {
                    formule = "u" + b + "U" + B + "U" + A + "u" + a;
                    Cube.formule(formule);
                    mouvements.append(formule);
                } else if (ordreFaces.indexOf(A) > ordreFaces.indexOf(B)) {
                    formule = "U" + B + "u" + b + "u" + a + "U" + A;
                    Cube.formule(formule);
                    mouvements.append(formule);
                } else {
                    formule = "u" + b + "U" + B + "U" + A + "u" + a;
                    Cube.formule(formule);
                    mouvements.append(formule);
                }
            }
        }

        return mouvements.toString();
    }
}
