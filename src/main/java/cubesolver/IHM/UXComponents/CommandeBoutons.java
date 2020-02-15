package cubesolver.IHM.UXComponents;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CommandeBoutons extends JPanel {
    //Déclaration de chaque bouton
    private JButton pause  = new JButton(new ImageIcon("IHM/UXComponents/play2.png"));
    private JButton avancer = new JButton(new ImageIcon("IHM/UXComponents/avancer.png"));
    private JButton arriere  = new JButton(new ImageIcon("IHM/UXComponents/arriere.png"));
    private Color maCouleur = new Color(48, 48, 48);


    public CommandeBoutons(){
        this.setLayout(null);
        this.setBounds(1025, 10, 300, 75);
        this.setBackground(maCouleur);

        //Placement boutons
        arriere.setBounds(0, 0, 100, 75);
        pause.setBounds(100, 0, 100, 75);
        avancer.setBounds(200, 0, 100, 75);

        //Couleurs et Bordures
        arriere.setBackground(maCouleur);
        pause.setBackground(maCouleur);
        avancer.setBackground(maCouleur);

        arriere.setBorder(BorderFactory.createLineBorder(Color.white));
        pause.setBorder(BorderFactory.createLineBorder(Color.white));
        avancer.setBorder(BorderFactory.createLineBorder(Color.white));

        this.add(arriere); this.add(avancer); this.add(pause);



    }
}