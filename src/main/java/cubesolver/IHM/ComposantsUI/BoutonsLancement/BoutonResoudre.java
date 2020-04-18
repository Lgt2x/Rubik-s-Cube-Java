package cubesolver.IHM.ComposantsUI.BoutonsLancement;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonModele;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;

import java.awt.event.ActionEvent;

public class BoutonResoudre extends BoutonModele {
    public BoutonResoudre(String mouv, int x, int y, int largeur, int hauteur) { super(mouv, x, y, largeur, hauteur);}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Bouton résoudre
        GestionAffichage.formuleResolution = Solveur.resolution();

        GestionAffichage.tailleSolution = 0;
        for (String etape : GestionAffichage.formuleResolution) {
            GestionAffichage.tailleSolution += etape.length();
        }
        GestionAffichage.stringResolution();

        // Le cube a été résolu par la méthode résolution du solveur, il faut le mélanger à nouveau avant de l'actualiser
        Cube.formule(GestionAffichage.formuleMix);

        // Désactivation du bouton de résolution
        GestionAffichage.setEtat("resolution");

    }
}
