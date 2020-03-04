package cubesolver.Solveur.Etapes;
import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class CroixJaune extends EtapeResolution {
    String mouvement = "FLBRF";

    @Override
    public ArrayList<Character> effectuerEtape() {
        ArrayList<Character> mouvements = new ArrayList<>();
        //Repérer la configuration dans laquelle on se trouve, et faire la croix jaune

        for (int i=0; i<12; i++){
            if (Cube.aretes[i].appartientFace('F') &&Cube.aretes[i].appartientFace('U')){
                if((Cube.aretes[i].facelettes[0].color=='U' &&Cube.aretes[i].facelettes[0].face=='F') || (Cube.aretes[i].facelettes[0].color!='U' &&Cube.aretes[i].facelettes[0].face=='U')){
                    mouvements.add('u'); //On fait tourner la face du dessus (face jaune)
                    for (int j=0; j<12; j++){
                        if (Cube.aretes[j].appartientFace('F') &&Cube.aretes[j].appartientFace('U')){
                            if((Cube.aretes[j].facelettes[0].color=='U' &&Cube.aretes[j].facelettes[0].face=='F') || (Cube.aretes[j].facelettes[0].color!='U' &&Cube.aretes[j].facelettes[0].face=='U')){
                                mouvements.add('u'); //On fait tourner la face du dessus (face jaune)
                                for (int k=0; k<12; k++){
                                    if (Cube.aretes[k].appartientFace('F') &&Cube.aretes[k].appartientFace('U')){
                                        if((Cube.aretes[k].facelettes[0].color=='U' &&Cube.aretes[k].facelettes[0].face=='F') || (Cube.aretes[k].facelettes[0].color!='U' &&Cube.aretes[k].facelettes[0].face=='U')){
                                            //On est dans la configuration oÃ¹ il n'y a rien
                                            //On balance tous les mouvements de rÃ©solution
                                        }
                                    } else {
                                        // On est dans la configuration des cÃ´tes Ã  cÃ´tes
                                        mouvements.add('U'); //On se place dans la bonne position
                                       Cube.formule("FURurf"); //On balance tous les mouvements de rÃ©solution
                                    }
                                }
                            } else {
                                mouvements.add('u');
                                for (int k=0; k<12; k++){
                                    if((Cube.aretes[k].facelettes[0].color=='U' &&Cube.aretes[k].facelettes[0].face=='F') || (Cube.aretes[k].facelettes[0].color!='U' &&Cube.aretes[k].facelettes[0].face=='U')){
                                        //On est dans la configuration des opposÃ©s
                                        //On est dans la bonne position
                                       Cube.formule("FRUruf"); //On balance les mouvements de rÃ©solution
                                    } else {
                                        //On est dans la configuration des cÃ´tes Ã  cÃ´tes
                                       Cube.formule("uu"); //On se met dans la bonne position
                                       Cube.formule("FURurf"); //On balance les mouvements de rÃ©solution
                                    }
                                }
                            }
                        }
                    }

                } else {
                    mouvements.add('u'); //On fait tourner la face du dessus (face jaune)
                    for (int j=0; j<12; j++){
                        if (Cube.aretes[j].appartientFace('F') &&Cube.aretes[j].appartientFace('U')){
                            if((Cube.aretes[j].facelettes[0].color=='U' &&Cube.aretes[j].facelettes[0].face=='F') || (Cube.aretes[j].facelettes[0].color!='U' &&Cube.aretes[j].facelettes[0].face=='U')){
                                //On est dans la configuration des opposÃ©s
                               Cube.formule("FRUruf"); //On balance tous les mouvements de rÃ©solution
                            } else {
                                //On est dans la configuration des cÃ´tes Ã  cÃ´tes
                                Cube.formule("uu"); //On se met dans la bonne position
                                Cube.formule("FURurf"); //On balance les mouvements de rÃ©solution
                            }
                        }
                    }
                }
            }
        }
        return mouvements;
    }
}
