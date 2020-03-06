package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class PositionOfLastLayer extends EtapeResolution {

    @Override
    public String effectuerEtape() {
        StringBuilder mouvements = new StringBuilder();

        int i = 0;
        String u = "";
        String U = "";
        String formula;

        //placer les angles

        //mettre en place un angle
        while(!Cube.angles[1].estPositionneeCorrectement()){
            mouvements.append('U');
            Cube.mouvement('U');
        }
        // verifeir si tous les angles sont en place ou non
        if(Cube.angles[0].estPositionneeCorrectement() && Cube.angles[2].estPositionneeCorrectement() && Cube.angles[3].estPositionneeCorrectement()){
        }else{
            //coriger la parité
            if(Cube.angles[0].estPositionneeCorrectement() ^ Cube.angles[2].estPositionneeCorrectement() ^ Cube.angles[3].estPositionneeCorrectement()){
                formula = "RUrurFRRuruRUrf";
                Cube.formule(formula);
                mouvements.append(formula);
            }
            //deux cas a traiter, 2 itérations max
            while(!Cube.angles[0].estPositionneeCorrectement()){
                formula = "RbRFFrBRFFRR";
                Cube.formule(formula);
                mouvements.append(formula);
            }
        }


        // placer les aretes
        // on teste d'abord les trois cas problématiques :

        //H
        if(Cube.aretes[0].appartientFace('R') && Cube.aretes[3].appartientFace('F')){
            formula = "RuRURURuruRRuRuRURURuruRRU";
            Cube.formule(formula);
            mouvements.append(formula);
            System.out.println("H");
        }
        //Z1
        if(Cube.aretes[0].appartientFace('L') && Cube.aretes[1].appartientFace('F')){
            formula = "RuRURURuruRRrUrururURURR";
            Cube.formule(formula);
            mouvements.append(formula);
            System.out.println("Z1");
        }
        //Z2
        if(Cube.aretes[0].appartientFace('B') && Cube.aretes[2].appartientFace('F')){
            formula = "RRUURRUURRURRUURRUURRu";
            Cube.formule(formula);
            mouvements.append(formula);
            System.out.println("Z2");
        }


        //placer la dernier face pour faire la formule;
        if(!(Cube.aretes[0].estPositionneeCorrectement() && Cube.aretes[1].estPositionneeCorrectement())){
            while(!Cube.aretes[i].estPositionneeCorrectement()){
                i++;
                u += "u";
                U += "U";
                System.out.println("tourne");
            }

            Cube.formule(u);
            for(int z=0; z<u.length(); z++){
                mouvements.append(u.charAt(z));
            }

            while(!(Cube.aretes[0].facelettes[1].face == Cube.angles[0].facelettes[1].face && Cube.aretes[1].facelettes[1].face == Cube.angles[0].facelettes[2].face)){
                formula = "rUrururURURR";
                Cube.formule(formula);
                mouvements.append(formula);
                System.out.println("erreur");
            }
            Cube.formule(U);
            mouvements.append(U);
        }
    return mouvements.toString();
    }

}
