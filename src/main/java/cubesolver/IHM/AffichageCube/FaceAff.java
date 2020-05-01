package cubesolver.IHM.AffichageCube;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

/**
 * Classe d'affichage d'une face du cube, composée de 9 facelettes sous forme de boutons
 */
public class FaceAff extends JPanel {
    private final JButton[] facelettes = new JButton[9];
    private final int position;
    private final Color[] couleurs = {
            new Color(255, 232, 14),    // Jaune
            new Color(52, 48, 255),      // Bleu
            new Color(255, 114, 0),     // Orange
            new Color(12, 228, 30),     // Vert
            new Color(227, 0, 0),       // Rouge
            new Color(255, 255, 255),     // Blance
    };

    public FaceAff(int position) {
        this.position = position;
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(200, 200));

        for (int i = 0; i < 9; i++) {
            facelettes[i] = new JButton();
            this.add(facelettes[i]);
        }
    }

    /**
     * Actualise l'affichage de la face à partir de l'extrait de l'export du cube
     * La méthode est appelée par la classe maître AffichageCube
     */
    public void actualise() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                facelettes[count].setBackground(this.couleurs[Cube.export[AffichageCube.ordre[position]][i][j]]);
                facelettes[count].setEnabled(GestionAffichage.getEtat().equals("melange"));
                count++;
            }
        }
    }
}