package cubesolver.IHM.AffichageCube;

import cubesolver.IHM.Etat;

import javax.swing.*;
import java.awt.*;

import static cubesolver.IHM.GestionAffichage.couleurFond;

/**
 * Classe chargée de l'affichage du cube dans un panel à partir de l'export fourni par la classe Cube
 */
public class AffichageCube extends JPanel implements Etat {
    public static int[] ordre = {3, 2, 0, 4, 5, 1};
    private static final FaceAff[] faces = new FaceAff[6];

    public AffichageCube() {
        this.setBounds(10, 10, 850, 640);
        this.setBackground(couleurFond);
        this.setLayout(new GridLayout(3, 4));

        /* Sur une grille 3*4, donne les positions de l'applat des faces

        .*..
        ****
        .*..

         */
        boolean[] positions = {false, true, false, false,
                true, true, true, true,
                false, true, false, false};

        //Placement des JPanel sur une grille de 3*4 de manière à former le patron du cube

        int count = 0;
        for (int i = 0; i < 12; i++) {
            if (positions[i]) {
                faces[ordre[count]] = new FaceAff(count);
                this.add(faces[ordre[count]]);
                count++;
            } else {
                JPanel panel = new JPanel();
                panel.setBackground((couleurFond));
                this.add(panel);
            }
        }

        repaint();
    }

    /**
     * Actualise l'affichage à partir de l'export du cube
     */
    public static void actualiseEtat() {
        for (FaceAff face : faces) {
            face.actualise();
        }
    }
}