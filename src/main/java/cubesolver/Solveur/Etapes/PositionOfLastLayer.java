package cubesolver.Solveur.Etapes;

import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class PositionOfLastLayer extends EtapeResolution {

    @Override
    public ArrayList<Character> effectuerEtape(Cube cube) {
        ArrayList<Character> mouvements = new ArrayList<>();
        
        int i = 0;
        String u = "";
        String U = "";

        //placer les angles

        //mettre en place un angle
        while(!cube.angles[1].estPositionneeCorrectement()){
            mouvements.add('U');
        }
        // verifeir si tous les angles sont en place ou non
        if(cube.angles[0].estPositionneeCorrectement() && cube.angles[2].estPositionneeCorrectement() && cube.angles[3].estPositionneeCorrectement()){
        }else{
            //coriger la parité
            if(cube.angles[0].estPositionneeCorrectement() ^ cube.angles[2].estPositionneeCorrectement() ^ cube.angles[3].estPositionneeCorrectement()){
                cube.formule("RUrurFRRuruRUrf");
            }
            //deux cas a traiter, 2 itérations max
            while(!cube.angles[0].estPositionneeCorrectement()){
                cube.formule("RbRFFrBRFFRR");
            }
        }


        // placer les aretes
        // on teste d'abord les deux cas problématiques :

        //H
        if(cube.aretes[0].appartientFace('R') && cube.aretes[3].appartientFace('F')){
            cube.formule("RuRURURuruRRuRuRURURuruRRU");
        }
        //Z1
        if(cube.aretes[0].appartientFace('L') && cube.aretes[1].appartientFace('F')){
            cube.formule("RuRURURuruRRrUrururURURR");
        }
        //Z2
        if(cube.aretes[0].appartientFace('B') && cube.aretes[2].appartientFace('F')){
            cube.formule("RRUURRUURRURRUURRUURRu");
        }
        //placer la dernier face pour faire la formule;
        if(!(cube.aretes[0].estPositionneeCorrectement() && cube.aretes[1].estPositionneeCorrectement())){
            while(!cube.aretes[i].estPositionneeCorrectement()){
                i++;
            }
            for(int j = 0; j<i; j++){
                u += "u";
                U += "U";
            }
            cube.formule(u);
            while(!(cube.aretes[0].estPositionneeCorrectement() && cube.aretes[1].estPositionneeCorrectement())){
                cube.formule("rUrururURURR");
            }
            cube.formule(U);
        }

    return mouvements;
    }

}
