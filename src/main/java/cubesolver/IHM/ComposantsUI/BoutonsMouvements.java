package cubesolver.IHM.ComposantsUI;

import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class BoutonsMouvements extends JPanel implements ActionListener {
    private JButton[] mouvements = new JButton[12];
    private String[] faces = {"R", "U", "L", "D", "F", "B",
            "r", "u", "l", "d", "f", "b"};

    public BoutonsMouvements(){
        this.setLayout(new GridLayout(2,6));
        this.setBounds(875, 205, 600, 150);
        this.setBackground(new Color(48, 48, 48));

        for (int i=0;i<faces.length;i++) {
            mouvements[i] = new JButton(faces[i]);

            mouvements[i].setBackground(new Color(48, 48, 48));
            mouvements[i].setForeground(Color.WHITE);
            mouvements[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));

            this.add(mouvements[i]);
            mouvements[i].addActionListener(this);
        }


    }

    public void actionPerformed(ActionEvent e) {
        JButton face = (JButton)(e.getSource());
        GestionAffichage.cube.mouvement(face.getText().charAt(0));
        GestionAffichage.actualise(GestionAffichage.cube.exportCube());
    }

}