package cubesolver.IHM.ComposantsUI;

import javax.swing.*;
import java.awt.*;

public  class BoutonsMouvements extends JPanel{
    JButton[] mouvements = new JButton[6];
    private Color maCouleur = new Color(48, 48, 48);
    public BoutonsMouvements(){
        this.setLayout(null);
        this.setBounds(875, 205, 600, 75);
        this.setBackground(maCouleur);

        mouvements[0] = new JButton("R");
        mouvements[1] = new JButton("U");
        mouvements[2] = new JButton("L");
        mouvements[3] = new JButton("D");
        mouvements[4] = new JButton("F");
        mouvements[5] = new JButton("B");

        //Fonction permettant de mettre la couleur du texte en blanc et ajout des boutons au panel
        placement();


    }

    public void placement(){
        int x = 0;
        for (JButton mouvement : mouvements) {
            mouvement.setBounds(x, 0, 100, 75);
            mouvement.setBackground(maCouleur);
            mouvement.setForeground(Color.WHITE);
            mouvement.setBorder(BorderFactory.createLineBorder(Color.white));
            this.add(mouvement);
            x += 100;
        }
    }

}