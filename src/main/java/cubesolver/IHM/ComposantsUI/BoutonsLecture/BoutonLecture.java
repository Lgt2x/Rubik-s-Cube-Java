package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.IHM.GestionAffichage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

/**
 * Classe abstraite définissant le style d'un bouton de lecture
 */
public abstract class BoutonLecture extends JButton implements ActionListener {
    public BoutonLecture(String imagePath, int x, int y, int largeur, int hauteur) {
        try {
            this.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath)))));
        } catch (IOException e) {
            System.out.println("Erreur de chargement d'une image");
        }

        this.setBounds(x, y, largeur, hauteur);
        this.setBackground(GestionAffichage.couleurBoutons);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.addActionListener(this);
    }
}
