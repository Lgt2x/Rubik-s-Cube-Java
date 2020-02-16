/* problème : il ne faudrait déclarer que 52 boutons et remplir le reste du grid layout avec du vide*/
package cubesolver.IHM.AffichageCube;

import java.awt.*;
import javax.swing.*;

public class AffichageCube extends JPanel{
    public final Dimension TAILLE_FACE = new Dimension(200,200);

    public AffichageCube(){
        this.setBounds(10,10,840,630);
        this.setBackground(new Color(255,255,255));

        Face affB = new Face();
        this.add(affB);

        System.out.println(affB.getSize());

        repaint();
    }
}