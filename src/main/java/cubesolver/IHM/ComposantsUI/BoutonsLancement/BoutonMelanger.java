package cubesolver.IHM.ComposantsUI.BoutonsLancement;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonModele;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;

public class BoutonMelanger extends BoutonModele {

    public BoutonMelanger(String mouv, int x, int y, int largeur, int hauteur) {
        super(mouv, x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Bouton de mélange
        GestionAffichage.ajouterMelange(Cube.melange(15));
        setEnabled(true);
        GestionAffichage.setEtat("melange");
    }
}
