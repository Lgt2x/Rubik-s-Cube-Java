package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.ComposantsUI.BoutonsLecture.*;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;

import static cubesolver.IHM.GestionAffichage.niemeMouv;

public class CommandeBoutons extends JPanel {

    public CommandeBoutons() {
        this.setLayout(null);
        this.setBounds(925, 10, 500, 75);

        this.add(new BoutonReculerEtape(0, 0, 100, 75));
        this.add(new BoutonReculerMouvement(100, 0, 100, 75));
        this.add(new BoutonFinir(400, 0, 100, 75));
        this.add(new BoutonAvancerMouvement(200, 0, 100, 75));
        this.add(new BoutonAvancerEtape(300, 0, 100, 75));

    }

    /**
     * Change l'indice de l'étape au fur et à mesure quo'on fait des mouvements
     * @param indexEtape
     */

    public static void changeEtape(int indexEtape) {
        int length = 0;

        for (int i = 0; i <= indexEtape; i++) {
            length += GestionAffichage.formuleResolution[i].length();
        }

        if (niemeMouv > length) {
            GestionAffichage.niemeEtape++;

        } else if (niemeMouv <= length - GestionAffichage.formuleResolution[indexEtape].length() + 1) {
            GestionAffichage.niemeEtape--;

        }

        System.out.println("|| "+GestionAffichage.formuleResolution[indexEtape].length()+"||"+ GestionAffichage.formuleResolution[0].length());
        System.out.println("Length - 1 : "+ (length - GestionAffichage.formuleResolution[indexEtape].length()));

        System.out.println("Length : " + length);
    }

    public static void actualiseMouv(int indexEtape){
        StringBuilder mouv = new StringBuilder();

        for (int i = 0; i <= indexEtape; i++) {
            mouv.append(GestionAffichage.formuleResolution[i]);
        }

        niemeMouv = mouv.length();
    }
}