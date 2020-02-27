/* problème : il ne faudrait déclarer que 52 boutons et remplir le reste du grid layout avec du vide*/
package cubesolver.IHM.AffichageCube;

import java.awt.*;
import javax.swing.*;

public class AffichageCube extends JPanel{
    public final Dimension TAILLE_FACE = new Dimension(200,200);
    public FaceAff[] faces = new FaceAff[6];

    public AffichageCube(){
        this.setBounds(10,10,850,640);
        this.setBackground(new Color(255,255,255));
        this.setLayout(new GridLayout(3,4));

        /**
         * Sur une grille 3*4, donne les positions de l'applat des faces
         */
        boolean[] positions = {false, true, false, false,
                                true, true, true, true,
                                false, true, false, false};

        int[] order = {3,2,0,4,5,1};

        int count = 0;
        for (int i=0;i<12;i++) {
            if (positions[i]) {
                faces[order[count]] = new FaceAff();
                this.add(faces[order[count]]);
                count++;
            } else {
                this.add(new JPanel());
            }
        }

        repaint();
    }

    public void actualise(int[][][] export) {
        for (int i=0;i<6;i++) {
            faces[i].actualise(export[i]);
        }
    }
}