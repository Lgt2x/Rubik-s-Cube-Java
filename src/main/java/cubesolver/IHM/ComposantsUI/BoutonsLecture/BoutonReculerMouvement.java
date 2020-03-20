package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.*;


public class BoutonReculerMouvement extends BoutonLecture implements ActionListener {
    public BoutonReculerMouvement(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/arriere.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (niemeMouv > 0) {
            Cube.mouvementInverse(formuleResolutionComplet.charAt(niemeMouv - 1));
            System.out.println(formuleResolutionComplet.charAt(niemeMouv - 1));

            niemeMouv--;
            mouvDansEtape--;

            if (mouvDansEtape < 0) {
                niemeEtape--;
                mouvDansEtape = formuleResolution[niemeEtape].length() - 1;
            }

            GestionAffichage.actualiseEtat();
            GestionAffichage.avctResol.repaint();

            debugLecteur();
        }
    }
}
