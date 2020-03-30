package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static cubesolver.IHM.GestionAffichage.formuleMix;

/**
 * Classe décrivant les deux boutons principaux de lancement de l'application:
 *  - Mélanger, qui fait 15 mouvements au hasard
 *  - Résoudre, qui mets l'app dans l'état de lecture de résolution après avoir résolu le cube
 */
public class BoutonLancement extends JPanel implements ActionListener, Etat {
    private static JButton solve = new JButton("Résoudre");
    private static JButton mix = new JButton("Melanger");

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

            // Réinitialise le reste de la formule de résolution
            GestionAffichage.setEtat("melange");
            Cube.formuleSymetrique(formuleMix);
            formuleMix = "";
            GestionAffichage.ajouterMelange(Cube.melange(15));
            GestionAffichage.actualiseEtat();


        } else if (e.getSource() == solve) {
            // Bouton résoudre

            // Calcul de la solution et parsing
            GestionAffichage.formuleResolution = Solveur.resolution();
            GestionAffichage.tailleSolution = 0;
            StringBuilder resolution = new StringBuilder();

            for (String etape : GestionAffichage.formuleResolution) {
                resolution.append(etape);
                GestionAffichage.tailleSolution += etape.length();
            }

            GestionAffichage.nbEtapesSolution = GestionAffichage.formuleResolution.length;
            GestionAffichage.formuleResolutionComplet = resolution.toString();


            // Le cube a été résolu par la méthode résolution du solveur
            // iIl faut le mélanger à nouveau avant de l'actualiser
            Cube.formule(formuleMix);

            // Désactivation du bouton de résolution
            GestionAffichage.setEtat("resolution");
        }
    }
}