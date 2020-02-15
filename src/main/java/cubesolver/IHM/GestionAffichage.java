package cubesolver.IHM;

import cubesolver.IHM.UXComponents.*;

import java.awt.*;
import javax.swing.*;

public class GestionAffichage extends JFrame{

    private AffichageCube affichageCube;
    private CommandeBoutons panneauBouton;
    private BoutonLancement panneauStart;
    private BoutonsMouvements panneauMouvements;
    private BoutonsMouvementInv panneauMouvementsInv;
    private BoutonSolution panneauSolution;
    private Color couleurFond = new Color(65, 115, 109);

    public GestionAffichage(){

        //initialisation de la fenetre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setBounds(0,0, getWidth(), getHeight());
        panneauPrincipal.setBackground(couleurFond);
        panneauPrincipal.setLayout(null);

        //Déclaration des panneaux
        affichageCube = new AffichageCube();
        affichageCube.setBackground(new Color(255,255,255));

        panneauBouton = new CommandeBoutons();
        panneauStart = new BoutonLancement();
        panneauMouvements = new BoutonsMouvements();
        panneauMouvementsInv = new BoutonsMouvementInv();
        panneauSolution = new BoutonSolution();


        // Ajout de chaque Panel au panel principal
        panneauPrincipal.add(affichageCube);
        panneauPrincipal.add(panneauBouton);
        panneauPrincipal.add(panneauStart);

        panneauPrincipal.add(panneauMouvements);
        panneauPrincipal.add(panneauMouvementsInv);
        panneauPrincipal.add(panneauSolution);


        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }
}