package cubesolver.IHM.ComposantsUI.BoutonsLecture;

import cubesolver.Cube.Cube;
import cubesolver.IHM.ComposantsUI.BoutonsCommande;
import cubesolver.IHM.GestionAffichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoutonReculerMouvement extends BoutonLecture implements ActionListener {
    public BoutonReculerMouvement(int x, int y, int largeur, int hauteur) {
        super("BoutonsIHM/arriere.png", x, y, largeur, hauteur);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (GestionAffichage.niemeMouv > 0) {
            Cube.formule(Character.toString(GestionAffichage.stringResolution().charAt(GestionAffichage.niemeMouv - 1)));
            GestionAffichage.actualiseEtat();
            BoutonsCommande.changeEtape(GestionAffichage.niemeEtape);
            GestionAffichage.niemeMouv--;
            System.out.println("Etape :" + GestionAffichage.niemeEtape);
            System.out.println("niemeMouv : " + GestionAffichage.niemeMouv);
            GestionAffichage.avctResol.repaint();
        }

    }
}
