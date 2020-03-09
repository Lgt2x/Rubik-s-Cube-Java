package cubesolver.IHM.ComposantsUI;

import cubesolver.Cube.Cube;
import cubesolver.IHM.GestionAffichage;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class CommandeBoutons extends JPanel {
    //Déclaration de chaque bouton

    private Color maCouleur = new Color(48, 48, 48);
    private JButton pause = new JButton();
    private JButton avancer = new JButton();
    private JButton arriere = new JButton();
    private JLabel text = new JLabel();
    private int niemeMouv = 0;

    public CommandeBoutons(){
        this.setLayout(null);
        this.setBounds(1025, 10, 300, 75);
        //this.setBackground(maCouleur);

        // Chargement des images des boutons
        // TODO : le faire dans des classes boutton séparées pour ne pas polluer ici
        try {
            pause.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/play2.png")))));
            avancer.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/avancer.png")))));
            arriere.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/arriere.png")))));
        } catch (IOException e) {
            System.out.println("Erreur de chargement d'une image");
        }

        //Placement boutons
        arriere.setBounds(0, 0, 100, 75);
        text.setBounds(100, 0, 100, 75);
        avancer.setBounds(200, 0, 100, 75);

        //Couleurs et Bordures
        arriere.setBackground(maCouleur);
        pause.setBackground(maCouleur);
        avancer.setBackground(maCouleur);

        arriere.setBorder(BorderFactory.createLineBorder(Color.white));
        pause.setBorder(BorderFactory.createLineBorder(Color.white));
        avancer.setBorder(BorderFactory.createLineBorder(Color.white));

        avancer.addActionListener(new avancerListener());
        arriere.addActionListener(new arriereListener());



        this.add(arriere); this.add(avancer); this.add(pause); this.add(text);



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
            text.setText(String.valueOf(niemeMouv));
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
            text.setText(String.valueOf(niemeMouv));
        }
    }

}