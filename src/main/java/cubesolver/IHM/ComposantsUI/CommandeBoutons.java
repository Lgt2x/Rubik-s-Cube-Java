package cubesolver.IHM.ComposantsUI;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CommandeBoutons extends JPanel {
    //Déclaration de chaque bouton

    private Color maCouleur = new Color(48, 48, 48);
    private JButton pause = new JButton();
    private JButton avancer = new JButton();
    private JButton arriere = new JButton();

    public CommandeBoutons(){
        this.setLayout(null);
        this.setBounds(1025, 10, 300, 75);
        this.setBackground(maCouleur);

        // Chargement des images des boutons
        // TODO : le faire dans des classes boutton séparées pour ne pas polluer ici
        try {
            pause.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/play2.png"))));
            avancer.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/avancer.png"))));
            arriere.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/arriere.png"))));
        } catch (IOException e) {
            System.out.println("Erreur de chargement d'une image");
        }

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