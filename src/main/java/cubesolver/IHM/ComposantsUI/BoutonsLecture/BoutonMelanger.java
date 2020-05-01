package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonMouvTemplate;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;

import static cubesolver.IHM.GestionAffichage.formuleMix;

/**
 * Bouton qui produit un mélange de 15 mouvements du Cube
 */
public class BoutonMelanger extends BoutonMouvTemplate {

    public BoutonMelanger(String mouv, int x, int y, int largeur, int hauteur) {
        super(mouv, x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GestionAffichage.setEtat("melange");
        Cube.formuleSymetrique(formuleMix);
        formuleMix = "";
        GestionAffichage.ajouterMelange(Cube.melange(15));
        GestionAffichage.actualiseEtat();
    }
}
