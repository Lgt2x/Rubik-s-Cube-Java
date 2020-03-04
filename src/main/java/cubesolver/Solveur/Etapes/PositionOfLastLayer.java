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

        //placer les angles

        //mettre en place un angle
        while(!Cube.angles[1].estPositionneeCorrectement()){
            mouvements.append("U");
        }
        // verifeir si tous les angles sont en place ou non
            if(Cube.angles[0].estPositionneeCorrectement() &&Cube.angles[2].estPositionneeCorrectement() && Cube.angles[3].estPositionneeCorrectement()){
        }else{
            //coriger la parité
            if(Cube.angles[0].estPositionneeCorrectement() ^ Cube.angles[2].estPositionneeCorrectement() ^ Cube.angles[3].estPositionneeCorrectement()){
                Cube.formule("RUrurFRRuruRUrf");
                mouvements.append("RUrurFRRuruRUrf");
            }
            //deux cas a traiter, 2 itérations max
            while(!Cube.angles[0].estPositionneeCorrectement()){
                Cube.formule("RbRFFrBRFFRR");
                mouvements.append("RbRFFrBRFFRR");
            }
        }


        // placer les aretes
        // on teste d'abord les deux cas problématiques :

        //H
        if(Cube.aretes[0].appartientFace('R') && Cube.aretes[3].appartientFace('F')){
            Cube.formule("RuRURURuruRRuRuRURURuruRRU");
        }
        //Z1
        if(Cube.aretes[0].appartientFace('L') && Cube.aretes[1].appartientFace('F')){
            Cube.formule("RuRURURuruRRrUrururURURR");
        }
        //Z2
        if(Cube.aretes[0].appartientFace('B') && Cube.aretes[2].appartientFace('F')){
            Cube.formule("RRUURRUURRURRUURRUURRu");
        }
        //placer la dernier face pour faire la formule;
        if(!(Cube.aretes[0].estPositionneeCorrectement() && Cube.aretes[1].estPositionneeCorrectement())){
            while(!Cube.aretes[i].estPositionneeCorrectement()){
                i++;
            }
            for(int j = 0; j<i; j++){
                u += "u";
                U += "U";
            }
            Cube.formule(u);
            while(!(Cube.aretes[0].estPositionneeCorrectement() && Cube.aretes[1].estPositionneeCorrectement())){
                Cube.formule("rUrururURURR");
            }
            Cube.formule(U);
        }

    return mouvements.toString();
    }

}
