package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonLecture;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonAvancerEtape extends BoutonLecture implements ActionListener {
    public BoutonAvancerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancer.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (GestionAffichage.niemeEtape < 5) {
            Cube.formule(GestionAffichage.formuleResolution[GestionAffichage.niemeEtape]);
            GestionAffichage.niemeMouv += GestionAffichage.formuleResolution[GestionAffichage.niemeEtape].length();
            GestionAffichage.niemeEtape++;

            GestionAffichage.avctResolution.repaint();
            GestionAffichage.actualise();
        }
    }
}
