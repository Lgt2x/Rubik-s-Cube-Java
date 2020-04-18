package cubesolver.IHM.ComposantsUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.couleurBoutons;

/**
 * Classe abstraite définissant le style d'un bouton qui ont tous le même style
 */
public abstract class BoutonModele extends JButton implements ActionListener {
    public BoutonModele(String mouv, int x, int y, int largeur, int hauteur){
        this.setBounds(x, y, largeur, hauteur);
        this.setBackground(couleurBoutons);
        this.setForeground(Color.white);
        this.setText(mouv);
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.addActionListener(this);
    }

}
