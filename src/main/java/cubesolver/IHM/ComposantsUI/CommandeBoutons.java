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

    private StringBuilder mouvFaits = new StringBuilder();
    private JButton boutonFinish = new JButton();
    private JButton boutonAvancerEtape = new JButton();
    private JButton boutonArriereEtape = new JButton();
    private JButton boutonAvancerMouv = new JButton();
    private JButton boutonArriereMouv = new JButton();


    // Avancement de la lecture de la solution
    public static int niemeMouv = 0;
    public static int niemeEtape = 0;

    public CommandeBoutons(){
        this.setLayout(null);
        this.setBounds(925, 10, 500, 75);
        //this.setBackground(maCouleur);

        // Chargement des images des boutons
        try {
            boutonAvancerEtape.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/avancer.png")))));
            boutonArriereEtape.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/arriere.png")))));
            boutonFinish.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/boutonFinish.png")))));
            boutonAvancerMouv.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/avancerMouv.png")))));
            boutonArriereMouv.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("BoutonsIHM/arriereMouv.png")))));
        } catch (IOException e) {
            System.out.println("Erreur de chargement d'une image");
        }
        // Placement boutons
        boutonArriereEtape.setBounds(0, 0, 100, 75);
        boutonArriereMouv.setBounds(100,0,100,75);
        boutonAvancerMouv.setBounds(200,0,100,75);
        boutonAvancerEtape.setBounds(300, 0, 100, 75);
        boutonFinish.setBounds(400,0,100,75);

        // Couleurs et Bordures
        Color couleurFond = new Color(48, 48, 48);
        boutonArriereEtape.setBackground(couleurFond);
        boutonAvancerEtape.setBackground(couleurFond);
        boutonFinish.setBackground(couleurFond);
        boutonAvancerMouv.setBackground(couleurFond);
        boutonArriereMouv.setBackground(couleurFond);


        boutonArriereEtape.setBorder(BorderFactory.createLineBorder(Color.white));
        boutonAvancerEtape.setBorder(BorderFactory.createLineBorder(Color.white));
        boutonFinish.setBorder(BorderFactory.createLineBorder(Color.white));
        boutonAvancerMouv.setBorder(BorderFactory.createLineBorder(Color.white));
        boutonArriereMouv.setBorder(BorderFactory.createLineBorder(Color.white));

        boutonAvancerEtape.addActionListener(new avancerListener());
        boutonArriereEtape.addActionListener(new arriereListener());
        boutonAvancerMouv.addActionListener(new avancerMouvListener());
        boutonArriereMouv.addActionListener(new arriereMouvListener());

        this.add(boutonArriereEtape);
        this.add(boutonAvancerEtape);
        this.add(boutonFinish);
        this.add(boutonAvancerMouv);
        this.add(boutonArriereMouv);
    }

    class avancerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try{
                Cube.formule(GestionAffichage.formuleResolution[niemeEtape]);
                GestionAffichage.actualise();
                niemeEtape++;
                GestionAffichage.avctResolution.repaint();
            } catch (IndexOutOfBoundsException e){
                System.out.println("Rubik's déjà résolu");
            }
        }
    }

    class arriereListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(niemeEtape>0){
                Cube.formuleSymetrique(GestionAffichage.formuleResolution[niemeMouv-1]);
                GestionAffichage.actualise();
                niemeEtape--;
                GestionAffichage.avctResolution.repaint();
            }
        }
    }

    class avancerMouvListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(niemeMouv<=GestionAffichage.stringResolution().length()){
                Cube.formule(Character.toString(GestionAffichage.stringResolution().charAt(niemeMouv)));
                GestionAffichage.actualise();
                niemeMouv++;
                changeEtape(niemeEtape);
                System.out.println("Etape :" +niemeEtape);
                System.out.println("niemeMouv : " +niemeMouv);
                GestionAffichage.avctResolution.repaint();
            }

        }
    }

    class arriereMouvListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(niemeMouv>0){
                Cube.formule(Character.toString(GestionAffichage.stringResolution().charAt(niemeMouv-1)));
                GestionAffichage.actualise();
                changeEtape(niemeEtape);
                niemeMouv--;
                System.out.println("Etape :" +niemeEtape);
                System.out.println("niemeMouv : " +niemeMouv);
                GestionAffichage.avctResolution.repaint();
            }

        }
    }


    public void changeEtape(int indexEtape){

        int length = 0;

        for(int i = 0; i<indexEtape;i++){
            length += GestionAffichage.formuleResolution[i].length();
        }

        if(niemeMouv>length){
            niemeEtape++;
        } else if(niemeMouv<length-GestionAffichage.formuleResolution[indexEtape].length()){
            niemeEtape--;
        }

        System.out.println("Length : "+length);

    }

}