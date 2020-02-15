package cubesolver.IHM.UXComponents;

import java.awt.*;
import javax.swing.*;

public class affBack extends JPanel{
    public JButton[] boutons = new JButton[9];

    public affBack(){
        this.setBounds(100, 10, 210, 210);
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(new Color(27, 102,255));

        //Initialisation des boutons
        /*for(int i=0; i<boutons.length;i++){
            boutons[i]=new JButton();
            boutons[i].setBackground(Color.green);
            this.add(boutons[i]);
        }*/



    }

    public void reCalculate(){
        //permet d'actualiser l'affichage

    }
}