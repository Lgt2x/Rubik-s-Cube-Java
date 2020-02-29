package cubesolver.IHM;

import cubesolver.Cube.Cube;
import cubesolver.IHM.AffichageCube.AffichageCube;
import cubesolver.IHM.ComposantsUI.*;
import cubesolver.Solveur.Solveur;

import java.awt.*;
import javax.swing.*;

public class GestionAffichage extends JFrame{

    public static Cube cube;
    public static Solveur solver;

    private static AffichageCube affichageCube;
    private CommandeBoutons panneauBouton;
    private BoutonLancement panneauStart;
    private BoutonsMouvements panneauMouvements;
    private BoutonSolution panneauSolution;
    private Color couleurFond = new Color(65, 115, 109);

    public GestionAffichage(Cube cube) {
        this.cube = new Cube();
        this.solver = new Solveur(cube);


        // Initialisation de la fenetre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation du panel principal
        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setBounds(0,0, getWidth(), getHeight());
        panneauPrincipal.setBackground(couleurFond);
        panneauPrincipal.setLayout(null);

        // Déclaration des panneaux secondaires
        affichageCube = new AffichageCube();
        panneauPrincipal.add(affichageCube);

        panneauBouton = new CommandeBoutons();
        panneauPrincipal.add(panneauBouton);

        panneauStart = new BoutonLancement();
        panneauPrincipal.add(panneauStart);

        panneauMouvements = new BoutonsMouvements();
        panneauPrincipal.add(panneauMouvements);

        panneauSolution = new BoutonSolution();
        panneauPrincipal.add(panneauSolution);

        // Affichage de la fenêtre
        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }

    public static void actualise(int[][][] export) {
        AffichageCube.actualise(export);
    }
}