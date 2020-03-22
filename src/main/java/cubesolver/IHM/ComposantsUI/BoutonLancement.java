package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonLancement extends JPanel implements ActionListener, Etat {
    private static JButton solve = new JButton("Résoudre");
    private static JButton mix = new JButton("Mélanger");

    public BoutonLancement() {
        Color couleurFond = new Color(48, 48, 48);

        this.setLayout(null);
        this.setBounds(1025, 95, 300, 100);
        this.setBackground(couleurFond);

        //Placement Boutons
        solve.setBounds(0, 0, 150, 100);
        mix.setBounds(150, 0, 150, 100);

        //Esthéthisme des boutons
        solve.setBackground(couleurFond);
        solve.setForeground(Color.WHITE);

        //Couleur du fond des boutons
        mix.setBackground(couleurFond);
        mix.setForeground(Color.WHITE);

        //Mettre les bordures des boutons en blanc
        solve.setBorder(BorderFactory.createLineBorder(Color.white));
        mix.setBorder(BorderFactory.createLineBorder(Color.white));

        mix.addActionListener(this);
        solve.addActionListener(this);

        this.add(solve);
        this.add(mix);
    }

    public static void actualiseEtat() {
        solve.setEnabled(GestionAffichage.getEtat().equals("melange"));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mix) {
            // Bouton de mélange
            GestionAffichage.ajouterMelange(Cube.melange(15));
            solve.setEnabled(true);
            GestionAffichage.setEtat("melange");

        } else if (e.getSource() == solve) {
            // Bouton résoudre
            GestionAffichage.formuleResolution = Solveur.resolution();

            GestionAffichage.tailleSolution = 0;
            for (String etape : GestionAffichage.formuleResolution) {
                GestionAffichage.tailleSolution += etape.length();
            }
            GestionAffichage.stringResolution();

            // Le cube a été résolu par la méthode résolution du solveur, il faut le mélanger à nouveau avant de l'actualiser
            Cube.formule(GestionAffichage.formuleMix);

            // Désactivation du bouton de résolution

            GestionAffichage.setEtat("resolution");
        }
    }
}