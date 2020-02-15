package cubesolver.IHM.UXComponents;

import javax.swing.*;
import java.awt.*;

public class BoutonSolution extends JPanel{
    private JButton solution = new JButton("Solution : ");
    private Color maCouleur = new Color(48, 48, 48);

    public BoutonSolution(){
        this.setLayout(null);
        this.setBounds(1025, 405, 300, 150);
        this.setBackground(maCouleur);

        //Placement du bouton
        solution.setBounds(0, 0, 300, 150);

        //Esthétisme du bouton
        solution.setBackground(maCouleur);
        solution.setForeground(Color.WHITE);
        solution.setBorder(BorderFactory.createLineBorder(Color.white));

        this.add(solution);
    }
}