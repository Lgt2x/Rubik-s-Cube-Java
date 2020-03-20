package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonLecture;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.ComposantsUI.CommandeBoutons.actualiseMouv;


public class BoutonAvancerEtape extends BoutonLecture implements ActionListener {
    public BoutonAvancerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancerMouv.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(GestionAffichage.niemeEtape<=4){
            Cube.formule(GestionAffichage.formuleResolution[GestionAffichage.niemeEtape]);
            GestionAffichage.actualise();
            actualiseMouv(GestionAffichage.niemeEtape);
            GestionAffichage.niemeEtape++;
            GestionAffichage.avctResolution.repaint();
        }
    }
}
