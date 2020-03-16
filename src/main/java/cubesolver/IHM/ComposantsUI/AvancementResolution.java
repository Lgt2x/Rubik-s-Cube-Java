package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

public class AvancementResolution extends JPanel {
    private int hauteur = 70;
    private int largeur = 400;
    private int tailleCercle = 10;

    public AvancementResolution() {
        this.setLayout(null);
        this.setBounds(975, 400, largeur, hauteur);
        this.setBackground(Color.white);

        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(GestionAffichage.couleurFond);
        g.fillRect(0,0,largeur,hauteur);

        g.setColor(Color.BLACK);
        g.drawLine(0,hauteur/2, largeur, hauteur/2);

        int avancement;
        if (GestionAffichage.tailleSolution != 0) {
            avancement = largeur * GestionAffichage.niemeMouv/GestionAffichage.tailleSolution;
        } else {
            avancement = 0;
        }

        g.fillOval(avancement - tailleCercle/2, hauteur/2-tailleCercle/2, tailleCercle, tailleCercle);

        System.out.println(GestionAffichage.niemeEtape);
    }
}
