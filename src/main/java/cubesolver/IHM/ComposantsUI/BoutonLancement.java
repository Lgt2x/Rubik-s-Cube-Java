package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;
import cubesolver.Solveur.Solveur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonLancement extends JPanel implements ActionListener {
    private JButton solve = new JButton("Résoudre");
    private JButton mix = new JButton("Mélanger");

    public BoutonLancement(){
        Color couleurFond = new Color(48, 48, 48);

        this.setLayout(null);
        this.setBounds(1025, 95, 300, 100);
        this.setBackground(couleurFond);

        //Placement Boutons
        solve.setBounds(0,0,150,100);
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

        this.add(solve); this.add(mix);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mix) {
            // Bouton de mélange
            GestionAffichage.formuleMix = Cube.melange(15);
            GestionAffichage.actualise();
        } else if (e.getSource() == solve) {
            // Bouton résoudre
            GestionAffichage.formuleResolution = Solveur.resolution();
            GestionAffichage.tailleSolution = 0;
            for (int i=0;i<GestionAffichage.formuleResolution.length;i++) {
                GestionAffichage.tailleSolution += GestionAffichage.formuleResolution[i].length();
            }
            Cube.formule(GestionAffichage.formuleMix);
            GestionAffichage.actualise();
        }
    }
}