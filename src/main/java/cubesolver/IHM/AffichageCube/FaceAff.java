package cubesolver.IHM.AffichageCube;
import java.awt.*;
import javax.swing.*;

public class FaceAff extends JPanel{
    public FaceletteAff[] facelettes = new FaceletteAff[9];
    public Color[] couleurs = {
        new Color(255, 245, 0),
        new Color(52, 48,255),
        new Color(255, 78, 0),
        new Color(1, 184, 29),
        new Color(255, 0, 0),
        new Color(255,255,255),
    };

    public FaceAff(){
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(new Color(0, 0, 0));
        this.setPreferredSize(new Dimension(200,200));

        for (int i=0;i<9;i++) {
            facelettes[i] = new FaceletteAff();
            this.add(facelettes[i]);
        }
    }

    public void actualise(int[][] face) {
        int count = 0;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                facelettes[count].changeCouleur(this.couleurs[face[i][j]]);
                count++;
            }
        }
    }
}