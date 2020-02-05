import java.awt.*;
import javax.swing.*;

public class fenetre extends JFrame{

    private AffichageCube affichageCube;
    private commandeBoutons panneauBouton;
    private boutonLancement panneauStart;
    private boutonsMouvements panneauMouvements;
    private boutonsMouvementInv panneauMouvementsInv;
    private boutonSolution panneauSolution;
    private Color maCouleur = new Color(48, 48, 48);

    public fenetre(){

        //initialisation de la fenetre
        this.setTitle("Solver de rubik's cube");
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panneauPrincipal = new JPanel();
        panneauPrincipal.setBounds(0,0, getWidth(), getHeight());
        panneauPrincipal.setBackground(maCouleur);
        panneauPrincipal.setLayout(null);

        //Déclaration des panneaux
        affichageCube = new AffichageCube();
        panneauBouton = new commandeBoutons();
        panneauStart = new boutonLancement();
        panneauMouvements = new boutonsMouvements();
        panneauMouvementsInv = new boutonsMouvementInv();
        panneauSolution = new boutonSolution();


        // Ajout de chaque Panel au panel principal
        panneauPrincipal.add(affichageCube); panneauPrincipal.add(panneauBouton); panneauPrincipal.add(panneauStart);
        panneauPrincipal.add(panneauMouvements); panneauPrincipal.add(panneauMouvementsInv); panneauPrincipal.add(panneauSolution);

        this.setContentPane(panneauPrincipal);
        this.setVisible(true);
    }



}