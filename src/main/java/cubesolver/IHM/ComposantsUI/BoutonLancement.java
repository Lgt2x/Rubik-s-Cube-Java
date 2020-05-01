package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;


/**
 * Classe décrivant les deux boutons principaux de lancement de l'application:
 *  - Mélanger, qui fait 15 mouvements au hasard
 *  - Résoudre, qui mets l'app dans l'état de lecture de résolution après avoir résolu le cube
 */
public class BoutonLancement extends JPanel implements Etat {
    private static boutonMouv solve;
    private static boutonMouv mix;


public class BoutonLancement extends JPanel implements ActionListener, Etat {
    private static JButton solve = new JButton("Résoudre");
    private static JButton mix = new JButton("Melanger");

    public BoutonLancement() {
        Color couleurFond = new Color(48, 48, 48);
        this.setLayout(null);
        this.setBounds(1025, 95, 300, 100);
        this.setBackground(couleurFond);

        solve = new boutonResoudre("Résoudre", 0,0,150,100);
        mix = new boutonMelanger("Mélanger", 150,0,150,100);

        this.add(solve);
        this.add(mix);
    }

    public static void actualiseEtat() {
        solve.setEnabled(GestionAffichage.getEtat().equals("melange"));
    }
}