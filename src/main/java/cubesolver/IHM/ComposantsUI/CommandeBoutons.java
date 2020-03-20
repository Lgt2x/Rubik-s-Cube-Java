package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.ComposantsUI.BoutonsLecture.*;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;

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

    public static void changeEtape(int indexEtape) {
        int length = 0;

        for (int i = 0; i < indexEtape; i++)
            length += GestionAffichage.formuleResolution[i].length();

        if (GestionAffichage.niemeMouv > length)
            GestionAffichage.niemeEtape++;
        else if (GestionAffichage.niemeMouv < length - GestionAffichage.formuleResolution[indexEtape].length())
            GestionAffichage.niemeEtape--;

        System.out.println("Length : " + length);

    }
}