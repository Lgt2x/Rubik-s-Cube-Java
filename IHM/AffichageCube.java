package IHM;/* problème : il ne faudrait déclarer que 52 boutons et remplir le reste du grid layout avec du vide*/
import IHM.Cube.Cube;
import java.awt.*;
import javax.swing.*;

public class AffichageCube extends JPanel{

    //private CarreCube[] carreCube = new CarreCube[52];
    private JButton[] bouton = new JButton[108];
    private static Color[] couleurs = new Color[] {new Color(255,255,255),
            new Color(30, 29, 173),
            new Color(195, 12,0),
            new Color(14,255, 29),
            new Color(248, 97,0),
            new Color(249, 206, 33)
    };

    public AffichageCube(){
        // Création du panel contenant les cotés des cubes
        this.setLayout(new GridLayout(9,12) );
        this.setBackground(Color.BLACK);
        this.setBounds(10,10,840,630); // Avoir des boutons carrés


        // Colorier tous les carrés comme un cube fini lors du démarage
        // Attention : Juste pour la phase initiale, tant qu'il n'y a pas de classe cube !
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
                bouton[i].setBackground(Color.BLACK);
            }
            this.add(bouton[i]);
        }
    }

    /**
     * Retourne la couleur correspondante au nombre demandé
     * @param color : entier dont on veut la couleur correspondante
     * @return
     */
    public static Color correspondanceCouleur (int color) {
        return couleurs[color];
    }
}
