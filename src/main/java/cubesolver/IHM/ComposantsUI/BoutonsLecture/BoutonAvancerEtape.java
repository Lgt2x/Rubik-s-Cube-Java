package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.ComposantsUI.BoutonsCommande.actualiseMouv;


public class BoutonAvancerEtape extends BoutonLecture implements ActionListener {
    public BoutonAvancerEtape(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancerMouv.png", x, y, largeur, hauteur);
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(GestionAffichage.niemeEtape<=4){
            Cube.formule(GestionAffichage.formuleResolution[GestionAffichage.niemeEtape]);

            actualiseMouv(GestionAffichage.niemeEtape);
            GestionAffichage.niemeEtape++;

            GestionAffichage.actualiseEtat();
        }
    }
}
