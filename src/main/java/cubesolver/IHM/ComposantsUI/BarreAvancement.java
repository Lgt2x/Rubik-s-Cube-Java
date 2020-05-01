package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

/**
 * Visualisation de la barre d'avancement de la lecture de solution :
 * un point avance sur une barre proportionnellement à l'avancement de la lecture
 */
public class BarreAvancement extends JPanel implements Etat {
    private final int hauteur = 70;
    private final int largeur = 400;

    public BarreAvancement() {
        this.setLayout(null);
        this.setBounds(975, 360, largeur, hauteur);
        this.setBackground(Color.white);

        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(GestionAffichage.couleurFond);
        g.fillRect(0, 0, largeur, hauteur);

        g.setColor(Color.BLACK);
        g.drawLine(0, hauteur / 2, largeur, hauteur / 2);

        int avancement;
        if (GestionAffichage.tailleSolution != 0) {
            avancement = largeur * GestionAffichage.niemeMouv / GestionAffichage.tailleSolution;
        } else {
            avancement = 0;
        }

        int tailleCercle = 10;
        g.fillOval(avancement - tailleCercle / 2, hauteur / 2 - tailleCercle / 2, tailleCercle, tailleCercle);
    }
}
