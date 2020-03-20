package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonLecture;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonReculerEtape extends BoutonLecture implements ActionListener {
    public BoutonReculerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/arriere.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(GestionAffichage.niemeEtape>0){
            Cube.formuleSymetrique(GestionAffichage.formuleResolution[GestionAffichage.niemeMouv-1]);
            GestionAffichage.actualise();
            GestionAffichage.niemeEtape--;
            GestionAffichage.avctResolution.repaint();
            GestionAffichage.actualise();
        }
    }
}
