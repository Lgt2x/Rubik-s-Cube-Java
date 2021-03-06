package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.*;

/**
 * Recul d'une étape dans la lecture de solution
 */
public class BoutonReculerEtape extends BoutonLecture implements ActionListener {
    public BoutonReculerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/arriereMouv.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (GestionAffichage.niemeEtape >= 0) {
            if (mouvDansEtape == 0 && niemeEtape > 0) {
                niemeEtape--;
                mouvDansEtape = formuleResolution[niemeEtape].length();
            }

            Cube.formuleSymetrique(formuleResolutionComplet.substring(
                    niemeMouv - mouvDansEtape,
                    niemeMouv
            ));

            niemeMouv -= mouvDansEtape;
            mouvDansEtape = 0;

            GestionAffichage.actualiseEtat();
        }
    }
}
