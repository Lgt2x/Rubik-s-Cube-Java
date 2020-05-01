package cubesolver.IHM.ComposantsUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.couleurBoutons;

/**
 * Modèle de bouton standardisé, avec sa couleur, son format, pour définir un style global
 */
public abstract class BoutonMouvTemplate extends JButton implements ActionListener {
    public BoutonMouvTemplate(String mouv, int x, int y, int largeur, int hauteur) {
        this.setBounds(x, y, largeur, hauteur);
        this.setBackground(couleurBoutons);
        this.setForeground(Color.white);
        this.setText(mouv);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.addActionListener(this);
    }
}
