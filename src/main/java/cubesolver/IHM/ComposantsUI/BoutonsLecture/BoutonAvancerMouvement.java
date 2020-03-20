package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonsCommande;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonAvancerMouvement extends BoutonLecture implements ActionListener {
    public BoutonAvancerMouvement(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/avancer.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (GestionAffichage.niemeMouv <= GestionAffichage.stringResolution().length()) {
            Cube.formule(Character.toString(GestionAffichage.stringResolution().charAt(GestionAffichage.niemeMouv)));
            GestionAffichage.actualiseEtat();
            GestionAffichage.niemeMouv++;
            BoutonsCommande.changeEtape(GestionAffichage.niemeEtape);
            System.out.println("Etape :" + GestionAffichage.niemeEtape);
            System.out.println("niemeMouv : " + GestionAffichage.niemeMouv);
            GestionAffichage.avctResol.repaint();
        }

    }
}
