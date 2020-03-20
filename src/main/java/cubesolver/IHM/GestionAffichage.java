package cubesolver.IHM;

import cubesolver.Cube.Cube;
import cubesolver.IHM.AffichageCube.AffichageCube;
import cubesolver.IHM.ComposantsUI.AvancementResolution;
import cubesolver.IHM.ComposantsUI.BoutonLancement;
import cubesolver.IHM.ComposantsUI.BoutonsMouvements;
import cubesolver.IHM.ComposantsUI.CommandeBoutons;

import javax.swing.*;
import java.awt.*;

public class GestionAffichage extends JFrame {
    public static String formuleMix;
    public static String[] formuleResolution;
    public static int tailleSolution;
    public static Color couleurFond = new Color(65, 115, 109);
    public static Color couleurBoutons = new Color(48, 48, 48);

    public static CommandeBoutons cmdBoutons;
    public static AvancementResolution avctResolution;

    // Avancement de la lecture de la solution
    public static int niemeMouv = 0;
    public static int niemeEtape = 0;

    public GestionAffichage() {
        // Initialisation de la fenetre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation du panel principal
        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setBounds(0, 0, getWidth(), getHeight());
        panneauPrincipal.setBackground(couleurFond);
        panneauPrincipal.setLayout(null);

        // Déclaration des panneaux secondaires
        panneauPrincipal.add(new AffichageCube());
        cmdBoutons = new CommandeBoutons();
        panneauPrincipal.add(cmdBoutons);
        panneauPrincipal.add(new BoutonLancement());
        panneauPrincipal.add(new BoutonsMouvements());
        avctResolution = new AvancementResolution();
        panneauPrincipal.add(avctResolution);

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

    public static String stringResolution(){
        StringBuilder resolution = new StringBuilder();
        for(String str : formuleResolution){
            resolution.append(str);
        }

        return resolution.toString();
    }
}