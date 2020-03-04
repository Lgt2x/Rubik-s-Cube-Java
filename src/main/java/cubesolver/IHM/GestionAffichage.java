package cubesolver.IHM;

import cubesolver.Cube.Cube;
import cubesolver.IHM.AffichageCube.AffichageCube;
import cubesolver.IHM.ComposantsUI.*;
import cubesolver.Solveur.Solveur;

import java.awt.*;
import javax.swing.*;

public class GestionAffichage extends JFrame{
    public static String formuleMix;
    public static String[] formuleResolution;

    public GestionAffichage() {
        // Initialisation de la fenetre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation du panel principal
        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setBounds(0,0, getWidth(), getHeight());
        panneauPrincipal.setBackground(new Color(65, 115, 109));
        panneauPrincipal.setLayout(null);

        // Déclaration des panneaux secondaires
        panneauPrincipal.add(new AffichageCube());
        panneauPrincipal.add(new CommandeBoutons());
        panneauPrincipal.add(new BoutonLancement());
        panneauPrincipal.add(new BoutonsMouvements());
        panneauPrincipal.add(new BoutonSolution());

        Cube.exportCube();
        actualise();

        // Affichage de la fenêtre
        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }

    public static void actualise() {
        Cube.exportCube();
        AffichageCube.actualise();
    }
}