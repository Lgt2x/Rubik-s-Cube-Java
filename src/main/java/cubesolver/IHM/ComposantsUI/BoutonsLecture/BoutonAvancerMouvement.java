package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.*;


public class BoutonAvancerMouvement extends BoutonLecture implements ActionListener {
    public BoutonAvancerMouvement(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancer.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (niemeMouv < tailleSolution) {
            Cube.mouvement(formuleResolutionComplet.charAt(niemeMouv));

            niemeMouv++;
            mouvDansEtape++;

            if (mouvDansEtape >= formuleResolution[niemeEtape].length() && niemeEtape < 4) {
                niemeEtape++;
                mouvDansEtape = 0;
            }

            GestionAffichage.actualiseEtat();
            GestionAffichage.avctResol.repaint();

        }

    }
}
