package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.IHM.ComposantsUI.BoutonLecture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonReculerMouvement extends BoutonLecture implements ActionListener {
    public BoutonReculerMouvement(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/arriereMouv.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
