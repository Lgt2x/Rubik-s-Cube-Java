package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.ComposantsUI.BoutonsLecture.*;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;

import static cubesolver.IHM.GestionAffichage.*;

/**
 * Conteneur des boutons de lecture de la solution, dans l'ordre :
 *  - Reculer d'une étape de résolution
 *  - Reculer d'un mouvement
 *  - Avancer d'un mouvement
 *  - Avancer d'une étape
 *  - Finir le cube entièrement
 */
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

            // Les boutons ne sont activés que lorsque l'app est en mode résolution
            if (GestionAffichage.getEtat().equals("resolution")) {
                // On ne peut reculer que si la lecture du cube n'est pas à la première étape
                if (niemeMouv <= 0
                        && (bouton instanceof BoutonReculerMouvement || bouton instanceof BoutonReculerEtape)) {
                    bouton.setEnabled(false);

                // De même, on n'avance que si on n'est pas à la fin
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