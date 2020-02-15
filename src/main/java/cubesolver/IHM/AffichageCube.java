/* problème : il ne faudrait déclarer que 52 boutons et remplir le reste du grid layout avec du vide*/
package cubesolver.IHM;

import cubesolver.IHM.UXComponents.affBack;

import java.awt.*;
import javax.swing.*;

public class AffichageCube extends JPanel{

    //private CarreCube[] carreCube = new CarreCube[52];
    private JButton[] bouton = new JButton[108];
    private Color maCouleur = new Color(255, 48, 49);

    public AffichageCube(){
        this.setBounds(10,10,840,630); // avoir des boutons carrés
        affBack affB = new affBack();
        affB.setLayout(new GridLayout(3, 3));
        affB.setBackground(new Color(124,255, 34));
        this.add(affB);
        this.setBackground(maCouleur);


        /*
        //creer le panel contenant les coté des cubes

        this.setLayout(new GridLayout(9,12) );

        this.setBackground(Color.GREEN);



        //colorier tous les carré comme un cube fini lors du démarrage
        for(int i=0; i<108; i++) {
            bouton[i] = new JButton();
            if ((i>2 && i<6)||(i>14 && i<18)||(i>26 && i<30) ){
                bouton[i].setBackground(Color.GREEN);
            }else if ((i>38 && i<42)||(i>50 && i<54)||(i>62 && i<66) ){
                bouton[i].setBackground(Color.WHITE);
            }else if ((i>74 && i<78)||(i>86 && i<90)||(i>98 && i<102) ){
                bouton[i].setBackground(Color.BLUE);
            }else if ((i>35 && i<39)||(i>47 && i<51)||(i>59 && i<63) ){
                bouton[i].setBackground(Color.RED);
            }else if ((i>41 && i<45)||(i>53 && i<57)||(i>65 && i<69) ){
                bouton[i].setBackground(Color.ORANGE);
            }else if ((i>44 && i<49)||(i>56 && i<60)||(i>68 && i<72) ){
                bouton[i].setBackground(Color.YELLOW);
            }else{
                bouton[i].setBackground(maCouleur);
            }
            this.add(bouton[i]);
        }

         */


    }
    //Actualise l'affichage à partir du moment où un export est fait
    public void paint(){
        //affBack.reCalculate();


    }



}