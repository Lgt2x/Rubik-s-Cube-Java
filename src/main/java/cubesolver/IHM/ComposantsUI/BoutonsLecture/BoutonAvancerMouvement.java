package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.IHM.ComposantsUI.BoutonLecture;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonAvancerMouvement extends BoutonLecture implements ActionListener {
    public BoutonAvancerMouvement(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancerMouv.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
