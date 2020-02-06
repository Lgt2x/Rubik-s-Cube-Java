import javax.swing.*;
import java.awt.*;

public  class boutonsMouvementInv extends JPanel{
    JButton[] mouvements = new JButton[6];
    private Color maCouleur = new Color(48, 48, 48);

    public boutonsMouvementInv(){
        this.setLayout(null);
        this.setBounds(875, 305, 600, 75);
        this.setBackground(maCouleur);

        mouvements[0] = new JButton("R inv");
        mouvements[1] = new JButton("U inv");
        mouvements[2] = new JButton("L inv");
        mouvements[3] = new JButton("D inv");
        mouvements[4] = new JButton("F inv");
        mouvements[5] = new JButton("B inv");

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