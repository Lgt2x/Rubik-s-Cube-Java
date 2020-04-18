package cubesolver.IHM.ComposantsUI.BoutonsLancement;

import cubesolver.IHM.ComposantsUI.BoutonModele;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;


public class ConteneurLancement extends JPanel implements Etat {
    private static BoutonModele solve;
    private static BoutonModele mix;

    public ConteneurLancement() {
        Color couleurFond = new Color(48, 48, 48);
        this.setLayout(null);
        this.setBounds(1025, 95, 300, 100);
        this.setBackground(couleurFond);

        solve = new BoutonResoudre("Résoudre", 0,0,150,100);
        mix = new BoutonMelanger("Mélanger", 150,0,150,100);

        this.add(solve); this.add(mix);
    }

    public static void actualiseEtat() {
        solve.setEnabled(GestionAffichage.getEtat().equals("melange"));
    }

}