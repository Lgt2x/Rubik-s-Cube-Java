package IHM;

import javax.swing.*;

public class GestionAffichage extends JFrame{

    private AffichageCube affichageCube;

    public GestionAffichage(){

        // Initialisation de la fenêtre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setLayout(null);

        // Initialisation de l'affichage du cube
        affichageCube = new AffichageCube();
        panneauPrincipal.add(affichageCube);

        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }



}