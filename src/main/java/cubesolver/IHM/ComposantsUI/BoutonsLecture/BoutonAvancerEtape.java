package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.*;

public class BoutonAvancerEtape extends BoutonLecture implements ActionListener {
    public BoutonAvancerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancerMouv.png", x, y, largeur, hauteur);
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        etapeSuivante();
        GestionAffichage.actualiseEtat();
    }

    public static void etapeSuivante() {
        if (GestionAffichage.niemeEtape < 4) {
            Cube.formule(formuleResolutionComplet.substring(
                    niemeMouv,
                    niemeMouv + (formuleResolution[niemeEtape].length() - mouvDansEtape)
            ));

            niemeMouv += formuleResolution[niemeEtape].length() - mouvDansEtape;
            niemeEtape++;
            mouvDansEtape = 0;

        } else if (niemeEtape == 4) {
            Cube.formule(formuleResolutionComplet.substring(
                    niemeMouv,
                    niemeMouv + (formuleResolution[niemeEtape].length() - mouvDansEtape)
            ));

            niemeMouv += formuleResolution[niemeEtape].length() - mouvDansEtape;
            mouvDansEtape = formuleResolution[niemeEtape].length();
        }
    }
}
