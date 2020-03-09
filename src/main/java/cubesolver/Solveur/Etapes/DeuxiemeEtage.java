package cubesolver.Solveur.Etapes;


import cubesolver.Cube.Cube;
import cubesolver.Solveur.EtapeResolution;

/**
 * Etape de résolution #3
 * Place les arêtes du deuxième étape
 */
public class DeuxiemeEtage extends EtapeResolution {
        @Override
        public String effectuerEtape(){
            StringBuilder mouvements = new StringBuilder();

            String mouvement = "RFLBR";
            String formula;
            String A;
            String a;
            String B;
            String b;
            String U = "U";
            String u = "u";
            int o;

            /*
            les angles du deuxieme etage sont ceux allant de 8 à 12
             */
            for(int i = 8; i<12; i++){
                //verifier si la pièce est deja positionée
                if(!Cube.aretes[i].estPositionneeCorrectement()){
                    //si elle n'est pas sur la face du haut, faire la formule afin de le mettre sur la face du haut
                    if(!Cube.aretes[i].appartientFace('U')){
                        o = Math.min(mouvement.indexOf(Cube.aretes[i].facelettes[0].face), mouvement.indexOf(Cube.aretes[i].facelettes[1].face));
                        if(o==0){
                            if(Cube.aretes[i].facelettes[0].face == 'B' || Cube.aretes[i].facelettes[1].face == 'B'){
                                o=3;
                            }
                        }

                        A = ""+mouvement.charAt(o+1);
                        a = A.toLowerCase();
                        B = ""+mouvement.charAt(o);
                        b = B.toLowerCase();

                        formula = U+B+u+b+u+a+U+A;
                        Cube.formule(formula);
                        for(int z=0; z<formula.length(); z++){
                            mouvements.append(formula.charAt(z));
                        }
                    }

                    //enregistrer la facelette qui est sur le dessus du Cube
                    //la face adjacente à pour valeur 0
                    o = 1;
                    if(Cube.aretes[i].facelettes[1].face == 'U'){
                        o = 0;
                    }
                    A = ""+Cube.aretes[i].facelettes[o].color;
                    a = A.toLowerCase();
                    B = ""+Cube.aretes[i].facelettes[(o+1)%2].color;
                    b = B.toLowerCase();

                    //mettre la pièce en position
                    while(Cube.aretes[i].facelettes[o].face != Cube.aretes[i].facelettes[o].color ){
                        mouvements.append('U');
                        Cube.mouvement('U');
                    }


                    //formule pour placer la pièce
                    if(A.charAt(0) == 'R' && B.charAt(0) == 'B'){
                        formula = U+B+u+b+u+a+U+A;
                        Cube.formule(formula);
                        for(int z=0; z<formula.length(); z++){
                            mouvements.append(formula.charAt(z));
                        }
                    }else if(A.charAt(0) == 'B' && B.charAt(0) == 'R'){
                        formula = u+b+U+B+U+A+u+a;
                        Cube.formule(formula);
                        for(int z=0; z<formula.length(); z++){
                            mouvements.append(formula.charAt(z));
                        }
                    }else if(mouvement.indexOf(A)>mouvement.indexOf(B)){
                        formula = U+B+u+b+u+a+U+A;
                        Cube.formule(formula);
                        for(int z=0; z<formula.length(); z++){
                            mouvements.append(formula.charAt(z));
                        }
                    }else{
                        formula = u+b+U+B+U+A+u+a;
                        Cube.formule(formula);
                        for(int z=0; z<formula.length(); z++){
                            mouvements.append(formula.charAt(z));
                        }
                    }
                }
            }
            return mouvements.toString();
        }
    }
