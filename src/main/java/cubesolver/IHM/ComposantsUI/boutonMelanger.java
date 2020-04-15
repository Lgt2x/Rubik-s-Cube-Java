package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;
import java.awt.event.ActionEvent;

public class boutonMelanger extends boutonMouv{

    public boutonMelanger(String mouv, int x, int y, int largeur, int hauteur) {
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
