package cubesolver.Solveur.etapes;
import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

import java.util.ArrayList;

public class CroixJaune extends EtapeResolution {
    String mouvement = "FLBRF";

    @Override
    public ArrayList<Character> effectuerEtape(Cube cube) {
        ArrayList<Character> mouvements = new ArrayList<>();
        //Repérer la configuration dans laquelle on se trouve, et faire la croix jaune

        for (int i=0; i<12; i++){
            if (cube.aretes[i].appartientFace('F') && cube.aretes[i].appartientFace('U')){
                if((cube.aretes[i].facelettes[0].color=='U' && cube.aretes[i].facelettes[0].face=='F') || (cube.aretes[i].facelettes[0].color!='U' && cube.aretes[i].facelettes[0].face=='U')){
                    mouvements.add('u'); //On fait tourner la face du dessus (face jaune)
                    for (int j=0; j<12; j++){
                        if (cube.aretes[j].appartientFace('F') && cube.aretes[j].appartientFace('U')){
                            if((cube.aretes[j].facelettes[0].color=='U' && cube.aretes[j].facelettes[0].face=='F') || (cube.aretes[j].facelettes[0].color!='U' && cube.aretes[j].facelettes[0].face=='U')){
                                mouvements.add('u'); //On fait tourner la face du dessus (face jaune)
                                for (int k=0; k<12; k++){
                                    if (cube.aretes[k].appartientFace('F') && cube.aretes[k].appartientFace('U')){
                                        if((cube.aretes[k].facelettes[0].color=='U' && cube.aretes[k].facelettes[0].face=='F') || (cube.aretes[k].facelettes[0].color!='U' && cube.aretes[k].facelettes[0].face=='U')){
                                            //On est dans la configuration oÃ¹ il n'y a rien
                                            //On balance tous les mouvements de rÃ©solution
                                        }
                                    } else {
                                        // On est dans la configuration des cÃ´tes Ã  cÃ´tes
                                        mouvements.add('U'); //On se place dans la bonne position
                                        cube.formule("FURurf"); //On balance tous les mouvements de rÃ©solution
                                    }
                                }
                            } else {
                                mouvements.add('u');
                                for (int k=0; k<12; k++){
                                    if((cube.aretes[k].facelettes[0].color=='U' && cube.aretes[k].facelettes[0].face=='F') || (cube.aretes[k].facelettes[0].color!='U' && cube.aretes[k].facelettes[0].face=='U')){
                                        //On est dans la configuration des opposÃ©s
                                        //On est dans la bonne position
                                        cube.formule("FRUruf"); //On balance les mouvements de rÃ©solution
                                    } else {
                                        //On est dans la configuration des cÃ´tes Ã  cÃ´tes
                                        cube.formule("uu"); //On se met dans la bonne position
                                        cube.formule("FURurf"); //On balance les mouvements de rÃ©solution
                                    }
                                }
                            }
                        }
                    }

                } else {
                    mouvements.add('u'); //On fait tourner la face du dessus (face jaune)
                    for (int j=0; j<12; j++){
                        if (cube.aretes[j].appartientFace('F') && cube.aretes[j].appartientFace('U')){
                            if((cube.aretes[j].facelettes[0].color=='U' && cube.aretes[j].facelettes[0].face=='F') || (cube.aretes[j].facelettes[0].color!='U' && cube.aretes[j].facelettes[0].face=='U')){
                                //On est dans la configuration des opposÃ©s
                                cube.formule("FRUruf"); //On balance tous les mouvements de rÃ©solution
                            } else {
                                //On est dans la configuration des cÃ´tes Ã  cÃ´tes
                                cube.formule("uu"); //On se met dans la bonne position
                                cube.formule("FURurf"); //On balance les mouvements de rÃ©solution
                            }
                        }
                    }
                }
            }
        }
        return mouvements;
    }
}
