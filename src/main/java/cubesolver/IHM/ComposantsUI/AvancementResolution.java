package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

public class AvancementResolution extends JPanel {
    private int hauteur = 70;
    private int largeur = 400;
    public AvancementResolution() {
        this.setLayout(null);
        this.setBounds(975, 400, largeur, hauteur);
        this.setBackground(Color.BLACK);

        repaint();
    }

    public void paint(Graphics g) {
        g.drawLine(0,hauteur/2, largeur, hauteur/2);
        g.
        System.out.println(CommandeBoutons.niemeEtape);
    }
}
