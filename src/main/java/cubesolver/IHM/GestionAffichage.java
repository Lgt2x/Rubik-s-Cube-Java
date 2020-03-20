package cubesolver.IHM;

import cubesolver.Cube.Cube;
import cubesolver.IHM.AffichageCube.AffichageCube;
import cubesolver.IHM.ComposantsUI.BarreAvancement;
import cubesolver.IHM.ComposantsUI.BoutonLancement;
import cubesolver.IHM.ComposantsUI.BoutonsMouvements;
import cubesolver.IHM.ComposantsUI.BoutonsCommande;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale de la gestion de l'affichage, qui contient tous les autres panels, boutons etc.
 */
public class GestionAffichage extends JFrame implements Etat{
    public static String formuleMix;
    public static String[] formuleResolution;
    public static String formuleResolutionComplet;
    public static int tailleSolution;

    public static Color couleurFond = new Color(65, 115, 109);
    public static Color couleurBoutons = new Color(48, 48, 48);

    public static BarreAvancement avctResol;

    // Avancement de la lecture de la solution
    public static int niemeMouv = 0; // Index du dernier mouvement effectué
    public static int niemeEtape = 0; // Index de l'étape en cours de lecture
    public static int mouvDansEtape = 0; // Numéro du dernier mouvement effectué dans l'étape

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
        panneauPrincipal.add(new BoutonsCommande());
        panneauPrincipal.add(new BoutonLancement());
        panneauPrincipal.add(new BoutonsMouvements());

        avctResol = new BarreAvancement();
        panneauPrincipal.add(avctResol);

        // Actualisation du contenu et des états des boutons
        formuleMix = "";
        actualiseEtat();


        // Affichage de la fenêtre
        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }

    /**
     * Actualise l'état de tous les composants de la fenêtre
     */
    public static void actualiseEtat() {
        // Affichage du cube
        Cube.exportCube();
        AffichageCube.actualise();

        // Actualisation de l'état des boutons
        BoutonsCommande.actualiseEtat();
        BoutonLancement.actualiseEtat();

    }

    public static void ajouterMelange(String sequence){
        formuleMix += sequence;
    }

    public static void stringResolution() {
        StringBuilder resolution = new StringBuilder();
        for (String str : formuleResolution) {
            resolution.append(str);
        }

        formuleResolutionComplet = resolution.toString();
    }

    public static String getEtat() {
        return etat;
    }

    public static void setEtat(String etatset) {
        etat = etatset;
        actualiseEtat();
    }

    public static void debugLecteur() {
        System.out.println("Etape : " + GestionAffichage.niemeEtape + "/" + (formuleResolution.length-1));
        System.out.println("niemeMouv : " + GestionAffichage.niemeMouv + "/" + (formuleResolutionComplet.length()-1));
        System.out.println("mouvDansEtape : " + mouvDansEtape + "/" + (formuleResolution[niemeEtape].length()-1));
        System.out.println();
    }
}