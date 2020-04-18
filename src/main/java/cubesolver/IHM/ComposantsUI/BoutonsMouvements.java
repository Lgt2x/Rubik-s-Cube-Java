package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.Etat;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe définissant les boutons pour faire des mouvements indépendants sur le cube
 */
public  class BoutonsMouvements extends JPanel implements ActionListener, Etat {
    private static JButton[] mouvements = new JButton[12];
    private String[] faces = {"R", "U", "L", "D", "F", "B", "r", "u", "l", "d", "f", "b"};

    public BoutonsMouvements(){
        this.setLayout(new GridLayout(2,6));
        this.setBounds(875, 205, 600, 150);
        this.setBackground(GestionAffichage.couleurBoutons);

        for (int i=0;i<faces.length;i++) {
            mouvements[i] = new JButton(faces[i]);

            mouvements[i].setBackground(GestionAffichage.couleurBoutons);
            mouvements[i].setForeground(Color.WHITE);
            mouvements[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));

            this.add(mouvements[i]);
            mouvements[i].addActionListener(this);
        }
    }


    /**
     * Au clic sur un bouton parmi les boutons de mouvement,
     * effectuer le mouvement correspondant sur le cube
     * @param e l'événement
     */
    public void actionPerformed(ActionEvent e) {
        GestionAffichage.setEtat("melange");
        JButton face = (JButton)(e.getSource());
        Cube.mouvement(face.getText().charAt(0));
        GestionAffichage.ajouterMelange(Character.toString(face.getText().charAt(0)));
        GestionAffichage.actualiseEtat();
    }

}