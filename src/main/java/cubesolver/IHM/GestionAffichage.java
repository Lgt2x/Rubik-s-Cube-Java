package cubesolver.IHM;

import cubesolver.Cube.Cube;
import cubesolver.IHM.AffichageCube.AffichageCube;
import cubesolver.IHM.ComposantsUI.AvancementResolution;
import cubesolver.IHM.ComposantsUI.BoutonLancement;
import cubesolver.IHM.ComposantsUI.BoutonsMouvements;
import cubesolver.IHM.ComposantsUI.CommandeBoutons;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale de la gestion de l'affichage, qui contient tous les autres panels, boutons etc.
 */
public class GestionAffichage extends JFrame {
    public static String formuleMix;
    public static String[] formuleResolution;
    public static int tailleSolution;

    public static Color couleurFond = new Color(65, 115, 109);
    public static Color couleurBoutons = new Color(48, 48, 48);

    public static AvancementResolution avctResol;

    // Avancement de la lecture de la solution
    public static int niemeMouv = 0;
    public static int niemeEtape = 0;

    private static String etat = "melange";

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
        panneauPrincipal.add(new CommandeBoutons());
        panneauPrincipal.add(new BoutonLancement());
        panneauPrincipal.add(new BoutonsMouvements());

        avctResol = new AvancementResolution();
        panneauPrincipal.add(avctResol);

        // Actualisation du contenu et des états des boutons
        actualise();

        // Affichage de la fenêtre
        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }

    public static void actualise() {
        // Affichage du cube
        Cube.exportCube();
        AffichageCube.actualise();

        // Actualisation de l'état des boutons
        CommandeBoutons.actualiseEtat();
        BoutonLancement.actualiseEtat();

    }

    public static String stringResolution() {
        StringBuilder resolution = new StringBuilder();
        for (String str : formuleResolution) {
            resolution.append(str);
        }

        return resolution.toString();
    }

    public static String getEtat() {
        return etat;
    }

    public static void setEtat(String etatset) {
        etat = etatset;
        actualise();
    }
}