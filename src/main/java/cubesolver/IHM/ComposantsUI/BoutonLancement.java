package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonLancement extends JPanel implements ActionListener {
    private JButton solve = new JButton("Résoudre");
    private JButton mix = new JButton("Mélanger");
    private Color maCouleur = new Color(48, 48, 48);

    public BoutonLancement(){
        this.setLayout(null);
        this.setBounds(1025, 95, 300, 100);
        this.setBackground(maCouleur);

        //Placement Boutons
        solve.setBounds(0,0,150,100);
        mix.setBounds(150, 0, 150, 100);

        //Esthéthisme des boutons
        solve.setBackground(maCouleur);
        solve.setForeground(Color.WHITE);

        //Couleur du fond des boutons
        mix.setBackground(maCouleur);
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
            System.out.println(GestionAffichage.cube.melange(15));
            GestionAffichage.actualise(GestionAffichage.cube.exportCube());
        } else if (e.getSource() == solve) {
            if (GestionAffichage.solver.peutFaireEtapeSuivante()) {
                System.out.println(GestionAffichage.solver.effectueEtapeSuivante());
                GestionAffichage.actualise(GestionAffichage.cube.exportCube());
            }
        }
    }
}