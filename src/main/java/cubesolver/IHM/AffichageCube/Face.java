package cubesolver.IHM.AffichageCube;

import java.awt.*;
import javax.swing.*;

public class Face extends JPanel{
    public JButton[] boutons = new JButton[9];

    public Face(){
        this.setLocation(100,10);
        //this.setLayout(new GridLayout(3, 3));
        this.setBackground(new Color(255, 1, 248));
        this.setPreferredSize(new Dimension(500,500));
    }
}