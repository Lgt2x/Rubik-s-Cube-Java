package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonLecture;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.ComposantsUI.CommandeBoutons.actualiseMouv;


public class BoutonReculerEtape extends BoutonLecture implements ActionListener {
    public BoutonReculerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/arriereMouv.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (GestionAffichage.niemeEtape > 0) {
            Cube.formuleSymetrique(GestionAffichage.formuleResolution[GestionAffichage.niemeMouv - 1]);
            GestionAffichage.actualise();
            actualiseMouv(GestionAffichage.niemeEtape);
            GestionAffichage.niemeEtape--;
            GestionAffichage.avctResol.repaint();
            GestionAffichage.actualise();
        }
    }
}
