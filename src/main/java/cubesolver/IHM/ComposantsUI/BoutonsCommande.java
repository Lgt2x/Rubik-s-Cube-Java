package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.ComposantsUI.BoutonsLecture.*;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;

import static cubesolver.IHM.GestionAffichage.niemeMouv;

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
     * Actualise l'état de chaque bouton
     */
    public static void actualiseEtat() {
        for (BoutonLecture bouton : boutonsLecture) {
            bouton.actualiseEtat();
        }
    }

    public static void actualiseMouv(int indexEtape){
        StringBuilder mouv = new StringBuilder();

        for (int i = 0; i <= indexEtape; i++) {
            mouv.append(GestionAffichage.formuleResolution[i]);
        }

        niemeMouv = mouv.length();
    }
}