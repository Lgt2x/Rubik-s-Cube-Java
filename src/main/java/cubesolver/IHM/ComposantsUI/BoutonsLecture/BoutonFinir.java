package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import static cubesolver.IHM.GestionAffichage.*;

public class BoutonFinir extends BoutonLecture {
    public BoutonFinir(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/boutonFinish.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        while (niemeMouv < tailleSolution) {
            BoutonAvancerEtape.etapeSuivante();
        }

        GestionAffichage.actualiseEtat();
    }
}
