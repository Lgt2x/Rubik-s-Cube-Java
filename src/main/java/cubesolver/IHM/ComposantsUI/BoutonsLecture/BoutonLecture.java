package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public abstract class BoutonLecture extends JButton implements ActionListener, Etat {
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

    /**
     * Actualise l'état du bouton en fonction de l'état de l'IHM
     * Si on est en phase de résolution, le bouton est activé, sinon il ne l'est pas
     */
    public void actualiseEtat() {
        this.setEnabled(GestionAffichage.getEtat().equals("resolution"));
    }
}
