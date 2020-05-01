package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.*;

/**
 * Bouton pour avancer d'une étape entière dans la lecture de la solution
 */
public class BoutonAvancerEtape extends BoutonLecture implements ActionListener {
    public BoutonAvancerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancerMouv.png", x, y, largeur, hauteur);
        this.setEnabled(false);
    }

    public static void etapeSuivante() {
        if (GestionAffichage.niemeEtape < nbEtapesSolution - 1) {
            Cube.formule(formuleResolutionComplet.substring(
                    niemeMouv,
                    niemeMouv + (formuleResolution[niemeEtape].length() - mouvDansEtape)
            ));

            niemeMouv += formuleResolution[niemeEtape].length() - mouvDansEtape;
            niemeEtape++;
            mouvDansEtape = 0;

        } else if (niemeEtape == nbEtapesSolution - 1) {
            Cube.formule(formuleResolutionComplet.substring(
                    niemeMouv,
                    niemeMouv + (formuleResolution[niemeEtape].length() - mouvDansEtape)
            ));

            niemeMouv += formuleResolution[niemeEtape].length() - mouvDansEtape;
            mouvDansEtape = formuleResolution[niemeEtape].length();
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        etapeSuivante();
        GestionAffichage.actualiseEtat();
    }
}
