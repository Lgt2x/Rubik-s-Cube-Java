package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;


/**
 * Etape de résolution #5
 * Positionne correctement les coins et arêtes de la dernière face
 * A la fin : le cube est résolu
 */
public class PositionOfLastLayer extends EtapeResolution {

    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();


        String formula;

        // **** Placement des angles ****
        // Mettre en place un angle
        while(!Cube.angles[1].estPositionneeCorrectement()){
            mouvements.append('U');
            Cube.mouvement('U');
        }
        // Vérifier si tous les angles sont en place ou non
        if(!(Cube.angles[0].estPositionneeCorrectement() && Cube.angles[2].estPositionneeCorrectement() && Cube.angles[3].estPositionneeCorrectement())) {
            // Coriger la parité
            if(Cube.angles[0].estPositionneeCorrectement() ^ Cube.angles[2].estPositionneeCorrectement() ^ Cube.angles[3].estPositionneeCorrectement()){
                formula = "RUrurFRRuruRUrf";
                Cube.formule(formula);
                mouvements.append(formula);
            }

            // Deux cas a traiter, 2 itérations max
            while(!Cube.angles[0].estPositionneeCorrectement()){
                formula = "RbRFFrBRFFRR";
                Cube.formule(formula);
                mouvements.append(formula);
            }
        }


        // **** Placement des aretes ****
        // On teste d'abord les trois cas problématiques

        //H
        if(Cube.aretes[0].appartientFace('R') && Cube.aretes[3].appartientFace('F')){
            formula = "RuRURURuruRRuRuRURURuruRRU";
            Cube.formule(formula);
            mouvements.append(formula);
        }
        //Z1
        if(Cube.aretes[0].appartientFace('L') && Cube.aretes[1].appartientFace('F')){
            formula = "RuRURURuruRRrUrururURURR";
            Cube.formule(formula);
            mouvements.append(formula);
        }
        //Z2
        if(Cube.aretes[0].appartientFace('B') && Cube.aretes[2].appartientFace('F')){
            formula = "RRUURRUURRURRUURRUURRu";
            Cube.formule(formula);
            mouvements.append(formula);
        }


        // **** Placement de la dernière face pour faire la formule ****
        if(!(Cube.aretes[0].estPositionneeCorrectement()&& Cube.aretes[1].estPositionneeCorrectement())){

            int i = 0;
            StringBuilder uBuilder = new StringBuilder();
            while(!Cube.aretes[i].estPositionneeCorrectement()){
                i++;
                uBuilder.append("u");
            }
            Cube.formule(uBuilder.toString());
            mouvements.append(uBuilder);

            while(!(Cube.aretes[0].facelettes[1].face == Cube.angles[0].facelettes[1].face
                    && Cube.aretes[1].facelettes[1].face == Cube.angles[0].facelettes[2].face)) {
                formula = "rUrururURURR";
                Cube.formule(formula);
                mouvements.append(formula);
            }

            Cube.formule(uBuilder.toString().toUpperCase());
            mouvements.append(uBuilder.toString().toUpperCase());
        }
    return mouvements.toString();

    }

}
