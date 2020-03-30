package cubesolver.IHM;

import cubesolver.Cube.Cube;
import cubesolver.IHM.AffichageCube.AffichageCube;
import cubesolver.IHM.ComposantsUI.*;
import cubesolver.Solveur.Solveur;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale de la gestion de l'affichage, qui contient tous les autres panels, boutons etc.
 */
public class GestionAffichage extends JFrame implements Etat {
    public static String formuleMix = ""; // Formule de mélange utilisée
    public static String[] formuleResolution = new String[5]; // Tableau des formules utilisées pour chaque étape de résolution
    public static String formuleResolutionComplet = ""; // Formule de résolution agrégée en un string
    public static int tailleSolution = 0; // Taille totale de la solution
    public static int nbEtapesSolution = 0; // Nombre d'étapes dans la solution

    public static Color couleurFond = new Color(81, 81, 81);
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
        this.setSize(1500, 690);
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
        panneauPrincipal.add(new FormuleSolution());

        avctResol = new BarreAvancement();
        panneauPrincipal.add(avctResol);

        // Actualisation du contenu et des états des boutons
        setEtat("melange");


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
        AffichageCube.actualiseEtat();

        // Actualisation de l'état des boutons
        BoutonsCommande.actualiseEtat();
        BoutonLancement.actualiseEtat();
        FormuleSolution.actualiseEtat();

        // Actualisation de la barre de progression
        avctResol.repaint();
    }

    /**
     * Ajout à la formule de mélange d'une chaine donnée
     *
     * @param sequence la chaîne à ajouter
     */
    public static void ajouterMelange(String sequence) {
        formuleMix += sequence;
    }

    /**
     * Getter pour l'état
     *
     * @return l'état de l'IHM : "melange" ou "resolution"
     */
    public static String getEtat() {
        return etat;
    }

    /**
     * Setter pour l'état
     * Quand on repasse en phase mélange, reset du lecteur
     *
     * @param etatset l'état à mettre : "melange" ou "resolution"
     */
    public static void setEtat(String etatset) {
        if (etatset.equals("melange")) {
            // Reset de la résolution
            Solveur.reset();

            formuleMix += formuleResolutionComplet.substring(0, niemeMouv);

            // Reset de la formule de mélange si on part du cue totalement résolu
            if (niemeMouv >= tailleSolution) {
                formuleMix = "";
            }

            formuleResolution = new String[5];
            formuleResolutionComplet = "";
            niemeMouv = 0;
            niemeEtape = 0;
            mouvDansEtape = 0;
        }

        etat = etatset;
        actualiseEtat();
    }

    /**
     * Affiche des information concernant la lecture, pour débugguer le lecteur plus facilement
     */
    public static void debugLecteur() {
        System.out.println("Etape : " + GestionAffichage.niemeEtape + "/" + (nbEtapesSolution - 1));
        System.out.println("niemeMouv : " + GestionAffichage.niemeMouv + "/" + (tailleSolution - 1));
        System.out.println("mouvDansEtape : " + mouvDansEtape + "/" + (formuleResolution[niemeEtape].length() - 1));
        System.out.println();
    }
}