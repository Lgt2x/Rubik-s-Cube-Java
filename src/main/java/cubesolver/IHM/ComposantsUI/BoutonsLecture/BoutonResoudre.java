package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonMouvTemplate;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;

import java.awt.event.ActionEvent;

import static cubesolver.IHM.GestionAffichage.formuleMix;

/**
 * Bouyon de résolution
 */
public class BoutonResoudre extends BoutonMouvTemplate {
    public BoutonResoudre(String mouv, int x, int y, int largeur, int hauteur) {
        super(mouv, x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Calcul de la solution et parsing

        GestionAffichage.formuleResolution = Solveur.resolution();
        GestionAffichage.tailleSolution = 0;
        StringBuilder resolution = new StringBuilder();

        for (String etape : GestionAffichage.formuleResolution) {
            resolution.append(etape);
            GestionAffichage.tailleSolution += etape.length();
        }

        GestionAffichage.nbEtapesSolution = GestionAffichage.formuleResolution.length;
        GestionAffichage.formuleResolutionComplet = resolution.toString();


        // Le cube a été résolu par la méthode résolution du solveur
        // Il faut le mélanger à nouveau avant de l'actualiser
        Cube.formule(formuleMix);

        // Désactivation du bouton de résolution
        GestionAffichage.setEtat("resolution");

    }
}
