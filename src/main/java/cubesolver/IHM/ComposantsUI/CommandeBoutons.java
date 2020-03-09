package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CommandeBoutons extends JPanel {

    private Color couleurFond = new Color(48, 48, 48);
    private JButton boutonPause = new JButton();
    private JButton boutonAvancer = new JButton();
    private JButton boutonArriere = new JButton();
    private JLabel champTexte = new JLabel();
    private int niemeMouv = 0;

    public CommandeBoutons(){
        this.setLayout(null);
        this.setBounds(1025, 10, 300, 75);
        //this.setBackground(maCouleur);

        // Chargement des images des boutons
        // TODO : le faire dans des classes boutton séparées pour ne pas polluer ici
        try {
            boutonPause.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/play2.png"))));
            boutonAvancer.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/avancer.png"))));
            boutonArriere.setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/arriere.png"))));
        } catch (IOException e) {
            System.out.println("Erreur de chargement d'une image");
        }

        // Placement boutons
        boutonArriere.setBounds(0, 0, 100, 75);
        champTexte.setBounds(100, 0, 100, 75);
        boutonAvancer.setBounds(200, 0, 100, 75);

        // Couleurs et Bordures
        boutonArriere.setBackground(couleurFond);
        boutonPause.setBackground(couleurFond);
        boutonAvancer.setBackground(couleurFond);

        boutonArriere.setBorder(BorderFactory.createLineBorder(Color.white));
        boutonPause.setBorder(BorderFactory.createLineBorder(Color.white));
        boutonAvancer.setBorder(BorderFactory.createLineBorder(Color.white));

        boutonAvancer.addActionListener(new avancerListener());
        boutonArriere.addActionListener(new arriereListener());

        this.add(boutonArriere);
        this.add(boutonAvancer);
        this.add(boutonPause);
        this.add(champTexte);
    }

    class avancerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            niemeMouv++;
            if(niemeMouv>GestionAffichage.formuleResolution.length){
                niemeMouv--;
            } else {
                for(int i=0; i<=niemeMouv;i++){
                    Cube.formule(GestionAffichage.formuleResolution[i]);
                    GestionAffichage.actualise();
                }
            }
            champTexte.setText(String.valueOf(niemeMouv));
        }
    }

    class arriereListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            niemeMouv--;
            if(niemeMouv<0){
                niemeMouv=0;
            } else {
                for(int i=0; i<=niemeMouv;i++){
                    Cube.formule(GestionAffichage.formuleResolution[i]);
                    GestionAffichage.actualise();
                }
            }
            champTexte.setText(String.valueOf(niemeMouv));
        }
    }

}