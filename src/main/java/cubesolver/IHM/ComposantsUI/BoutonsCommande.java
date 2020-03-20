package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.ComposantsUI.BoutonsLecture.*;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;

import static cubesolver.IHM.GestionAffichage.*;

public class BoutonsCommande extends JPanel implements Etat {
    private static BoutonLecture[] boutonsLecture;

    public BoutonsCommande() {
        this.setLayout(null);
        this.setBounds(925, 10, 500, 75);

        boutonsLecture = new BoutonLecture[]{
                new BoutonReculerEtape(0, 0, 100, 75),
                new BoutonReculerMouvement(100, 0, 100, 75),
                new BoutonFinir(400, 0, 100, 75),
                new BoutonAvancerMouvement(200, 0, 100, 75),
                new BoutonAvancerEtape(300, 0, 100, 75)
        };

        for (BoutonLecture bouton : boutonsLecture) {
            this.add(bouton);
        }

    }

    /**
     * Actualise l'état de chaque bouton en fonction de l'état de l'IHM
     * Si on est en phase de résolution, le bouton est activé, sinon il ne l'est pas
     */
    public static void actualiseEtat() {
        for (BoutonLecture bouton : boutonsLecture) {
            bouton.setEnabled(true);

            if (GestionAffichage.getEtat().equals("resolution")) {
                if (niemeMouv <= 0
                        && (bouton instanceof BoutonReculerMouvement || bouton instanceof BoutonReculerEtape)) {
                    bouton.setEnabled(false);
                } else if (niemeMouv >= tailleSolution
                    && (bouton instanceof BoutonAvancerMouvement || bouton instanceof BoutonAvancerEtape || bouton instanceof BoutonFinir)) {
                    bouton.setEnabled(false);
                }
            } else {
                bouton.setEnabled(false);
            }

        }
    }
}