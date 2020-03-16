package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

public class BoutonSolution extends JPanel{
    private JButton solution = new JButton("Solution : ");

    public BoutonSolution(){
        this.setLayout(null);
        this.setBounds(1025, 405, 300, 150);
        this.setBackground(GestionAffichage.couleurBoutons);

        //Placement du bouton
        solution.setBounds(0, 0, 300, 150);

        //Esthétisme du bouton
        solution.setBackground(GestionAffichage.couleurBoutons);
        solution.setForeground(Color.WHITE);
        solution.setBorder(BorderFactory.createLineBorder(Color.white));

        this.add(solution);
    }
}